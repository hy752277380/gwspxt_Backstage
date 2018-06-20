$(function() {
			var data = {
				user: JSON.parse(sessionStorage.getItem("loginUser")),
				lhs_edit: JSON.parse(sessionStorage.getItem("lhs_edit")),
				docData: '', //所有数据
			}
			var detailDoc = new Vue({
					el: "#main",
					data: data,
					methods: {
						getInfo(params) {
							$.post('http://localhost:8080/gwspxt/documentBaseInfo/'+lhs_edit, params, function(response) {

							}, 'json');
						},

						mounted() {
							this.getInfo({

							});
						},
						watch: {},
						components: {}
					});
			})

