/*
$(function() {
			var lhs_edit = JSON.parse(sessionStorage.getItem("lhs_edit"));
			$.ajax({
				url: "http://localhost:8080/gwspxt/documentBaseInfo/" + lhs_edit.doc_id,
				type: "get",
				timeout: 3000,
				data: {},
				dataType: "json",
				success: function(data) {
					if(data) {

					} else {

					}
				}
			});
})*/
$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
         lhs_edit: JSON.parse(sessionStorage.getItem("lhs_edit"))，
        docData: '', //所有数据

    }


   

    var detailDoc = new Vue({
        el: "#main",
        data: data,
        methods: {

            getInfo(params) {
                $.post('http://localhost:8080/gwspxt/documentBaseInfo/'+lhs_edit, params, function (response) {
                    detailDoc.docData = response.list;

                    detailDoc.ready = true;
                }, 'json');
            },

        mounted() {
            this.getInfo({
                currentPage: 1
            });
        },
        watch: {
            'page.currentPage': function (newVal, oldVal) {
                if (newVal > this.page.totalPage) {
                    this.page.totalPage = oldVal;
                    spop({
                        template: "没有这个页面",
                        style: "info",
                        autoclose: 2000
                    })
                } else if (newVal < 1) {
                    spop({
                        template: "输入页面有误",
                        style: "info",
                        autoclose: 2000
                    })
                } else if (!(/(^[0-9]*[1-9][0-9]*$)/.test(newVal))) {
                    spop({
                        template: "输入正确的数字",
                        style: "info",
                        autoclose: 2000
                    })
                } else {
                    this.getInfo({
                        currentPage: this.page.currentPage
                    });
                }
            },
        },
        components: {
            'page-util': pageUtil,
            'search-util': searchUtil,
        }
    });
})
