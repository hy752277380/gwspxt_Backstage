$(function() {
    var lhs_edit=JSON.parse(sessionStorage.getItem("lhs_edit"));
    var documentId=lhs_edit.doc_id;
    var documentTitle=$("#documentTitle");
    var documentNo=$("#documentNo");
    var documentUser=$("#documentUser");
    var doucmentContent=$("#doucmentContent");
    var documentRemark=$("#documentRemark");
var documentType=$("#documentType");
     $.ajax({
                url: "http://localhost:8080/gwspxt/documentBaseInfo",
                type: "get",
                timeout: 3000,
                data: {
                "documentId":documentId,
                },
                dataType: "json",
                success: function (data) {
                  documentTitle.val(data.document.documentTitle);
                  documentNo.val(data.document.documentNo);
                  documentUser.val(data.guser.userName);
                  doucmentContent.val(data.document.doucmentContent);
                  documentRemark.val(data.document.documentRemark);
                  $('#documentType').find('option[value='+data.document.documentType+']').atrr('selected','selected');
                  $("input[name=documentConfidential][value="+data.document.documentConfidential+"]").attr("checked",true);
                  $("input[name=documentSpeed][value="+data.document.documentSpeed+"]").attr("checked",true);

                /*for(var i=1;i<data.length;i++)
                        {
                         $('#documentType').append("<option value='' >"+data[i].documentType.documenttypeName+"</option>");
                        }
*/
                }
            });

})



/*
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
*/

