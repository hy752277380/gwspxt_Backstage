/*
$(function() {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        lhs_edit: JSON.parse(sessionStorage.getItem("lhs_edit")),
        ready: true,
        docData: '', //所有数据
    }

    var detailDoc = new Vue({
        el: "#main",
        data: data,
        methods: {
            getInfo(params) {
                var documentId = this.$data.lhs_edit.doc_id;
                $.post('/gwspxt/documentBaseInfo', {documentId: documentId}, function (response) {
                    detailDoc.docData = response;
                }, 'json');
            },
        },
        components: {
            'asideComponent': Layout,
        }
    });
})
*/
$(function() {

    var lhs_edit=JSON.parse(sessionStorage.getItem("lhs_edit"));
    var documentId=lhs_edit.doc_id;
    /*var operate=lhs_edit.action;*/
    var documentTitle=$("#documentTitle");
    var documentNo=$("#documentNo");
    var documentUser=$("#documentUser");
    var doucmentContent=$("#doucmentContent");
    var documentRemark=$("#documentRemark");


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

                  $("input[name=documentConfidential][value="+data.document.documentConfidential+"]").attr("checked",true);
                  $("input[name=documentSpeed][value="+data.document.documentSpeed+"]").attr("checked",true);
                  $('#documentType').find('option[value='+data.document.documentType+']').attr('selected','selected');
                  $('#documentDept').find('option[value='+data.document.documentDept+']').attr('selected','selected');
                  $('#documentProcess').find('option[value='+data.document.documentProcess+']').attr('selected','selected');
             /*  for(var i=1;i<data.length;i++)
                        {
                         $('#documentType').append("<option value='' >"+data[i].documentType.documenttypeName+"</option>");
                        }*/

                }
            });

})

