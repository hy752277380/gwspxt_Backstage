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

/*
{
    "loginCustom":
    {
        "guser":
        {
            "userId":"15478000",
            "userAccount":"15478000",
            "userPassword":"96e79218965eb72c92a549dd5a330112",
            "userName":"江南",
            "userSex":1,
            "userDepartment":"1",
            "userPosition":"1",
            "userPhonenumber":"18397997374",
            "userEmail":"lhs@qq.com",
            "userIntroduction":"董事会文员",
            "userPicture":"",
            "creationTime":null,
            "userIsdelete":0
        },
        "department":
        {
            "departmentId":"1",
            "departmentName":"办公室",
            "departmentPhone":null,
            "departmentIsdelete":null
        },
        "position":
        {
            "positionId":null,
            "positionDept":null,
            "positionPermission":null,
            "positionName":"董事长"
        },
        "permission":
        {
            "permissionId":null,
            "permissionLevel":5,
            "permissionRemark":null
        }
    }
}
*/