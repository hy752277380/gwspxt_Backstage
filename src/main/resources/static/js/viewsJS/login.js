function check() {

	if(document.getElementById("userAccount").value == "") {
		alert("用户名不能为空！");
		return false;
	} else
	if(document.getElementById("userPassword").value == "") {
		alert("密码不能为空！");
		return false;
	} else {
		var user = $('#userAccount').val();
		var pass = $('#userPassword').val();
		$.ajax({
			url: "http://localhost:8080/gwspxt/login/" + user + "/" + pass,
			type: "post",
			timeout: 3000,
			data: {},
			dataType: "json",
			success: function(data) {
				console.log(data)
				if(data.code == "20000") {
					sessionStorage.setItem("loginUser",data.loginCustom);
					window.location.href = "http://localhost:8080/gwspxt/information";
				} else if(data.code == "20001") {
					alert("没有该用户");

				} else {
					alert("密码错误，登录失败");
				}
			}

		});

	}

}