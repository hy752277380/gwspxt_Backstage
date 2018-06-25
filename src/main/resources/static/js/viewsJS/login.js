function check() {
    if (document.getElementById("userAccount").value == "") {
        alert("用户名不能为空！");
        return false;
    } else if (document.getElementById("userPassword").value == "") {
        alert("密码不能为空！");
        return false;
    } else {
        var user = $('#userAccount').val();
        var pass = $('#userPassword').val();
        $.ajax({
            url: "/gwspxt/login/" + user + "/" + pass,
            type: "post",
            timeout: 3000,
            data: {},
            dataType: "json",
            success: function (data) {
                if (data.code == "20000") {
                    //console.log(data.loginCustom);
                    sessionStorage.setItem("loginUser", JSON.stringify(data.loginCustom));
                    window.location.href = "/gwspxt/index";
                } else if (data.code == "20001") {
                    alert("没有该用户");
                } else {
                    alert("密码错误，登录失败");
                }
            }
        });
    }
}

$(function () {
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            check();
        }
    }

    
});
