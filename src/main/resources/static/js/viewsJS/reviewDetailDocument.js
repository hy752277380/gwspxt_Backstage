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
						   console.log(data.lhs_edit.doc_id);
							$.post('http://localhost:8080/gwspxt/documentBaseInfo', params, function(response) {
                            detailDoc.docData=response.list;

							}, 'json');
						},

						mounted() {
							this.getInfo({
                             documentId:lhs_edit.doc_id,

							});
						},
						watch: {},
						components: {}
						}
					});
			})

