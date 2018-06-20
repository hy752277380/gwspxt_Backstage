$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        docData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
    }

    var index = new Vue({
        el: "#main",
        data: data,
    });
})