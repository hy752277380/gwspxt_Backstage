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
							$.post('/gwspxt/documentBaseInfo/'+lhs_edit, params, function(response) {
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

