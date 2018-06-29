function check() {
    if (document.getElementById("userAccount").value == "") {
        spop({template: `账号不能为空`, style: "error", autoclose: 2000});
        return false;
    } else if (document.getElementById("userPassword").value == "") {
        spop({template: `密码不能为空`, style: "error", autoclose: 2000});
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
                   /* spop({template: `登录成功`, style: "success", autoclose: 2000});*/
                } else if (data.code == "20001") {
                    spop({template: `账户或密码错误`, style: "error", autoclose: 2000});
                } else {
                    spop({template: `账户或密码错误`, style: "error", autoclose: 2000});
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
    $.post('/gwspxt/backtoLogin', {}, function (response) {}, 'json');
    sessionStorage.removeItem("loginUser");
});
