$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'accountManagement',
        docData: '', //所有数据
        ready: false,
        docProcess:[],
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getProcess(){
                $.post('/gwspxt/getAllProcess',{},function (response) {
                    data.docProcess = response;
                    data.ready= true;
                }, 'json')
            }
        },


        mounted() {
            this.getProcess({});
        },
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });
    $('#addDoc').click(function() {
        var documentTitle = $('#documentTitle').val();
        var documentNo = $('#documentNo').val();
        var documentUser = $('#documentUser').val();
        var doucmentContent = $('#doucmentContent').val();
        var documentRemark = $('#documentRemark').val();
        var documentType = $("#documentType  option:selected").val();
        var documentDept = 1;
        var documentSpeed = $('input[type=radio][name=documentSpeed]:checked').val();
        var documentConfidential = $('input[type=radio][name=documentConfidential]:checked').val();
        var documentProcess = $("#documentProcess  option:selected").val();

        var data = {
            "documentTitle": documentTitle,
            "documentNo": documentNo,
            "documentUser": documentUser,
            "documentType": documentType,
            "documentDept": documentDept,
            "documentSpeed": documentSpeed,
            "documentConfidential": documentConfidential,
            "doucmentContent": doucmentContent,
            "documentRemark": documentRemark,
            "documentProcess": documentProcess,
        }

        $.ajax({
            type: "post",
            url: "/gwspxt/addDocument",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(data),
            success: function(data) {
                if(data) {

                    var documentId = data.documentId;
                    console.log(documentId);
                    $.ajax({
                        type: "post",
                        url: "/gwspxt/updateDocumentState",
                        dataType: "json",
                        data: JSON.stringify(data),
                        contentType: 'application/json;charset=UTF-8',
                        success: function(data) {
                            $.ajax({
                                type: "post",
                                url: "/gwspxt/messageNextOne",
                                dataType: "json",
                                data: {
                                    documentId: documentId,
                                },
                                success: function(data) {
                                    window.location.href = "/gwspxt/reviewDocument";
                                }
                            });

                        }
                    });
                } else {

                }
            }
        });

    });



    $('#addDraft').click(function() {
        var documentTitle = $('#documentTitle').val();
        var documentNo = $('#documentNo').val();
        var documentUser = $('#documentUser').val();
        var doucmentContent = $('#doucmentContent').val();
        var documentRemark = $('#documentRemark').val();
        var documentType = $("#documentType  option:selected").val();
        var documentDept = 1;
        var documentSpeed = $('input[type=radio][name=documentSpeed]:checked').val();
        var documentConfidential = $('input[type=radio][name=documentConfidential]:checked').val();
        var documentProcess = $("#documentProcess  option:selected").val();

        var data = {
            "documentTitle": documentTitle,
            "documentNo": documentNo,
            "documentUser": documentUser,
            "documentType": documentType,
            "documentDept": documentDept,
            "documentSpeed": documentSpeed,
            "documentConfidential": documentConfidential,
            "doucmentContent": doucmentContent,
            "documentRemark": documentRemark,
            "documentProcess": documentProcess,
        }

        $.ajax({
            type: "post",
            url: "/gwspxt/addDocument",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(data),
            success: function(data) {
                if(data) {
                    window.location.href = "/gwspxt/reviewDocument";
                    }
                    else {

                }
            }
        });

    });

})