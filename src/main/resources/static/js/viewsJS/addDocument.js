$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'accountManagement',
        docData: '', //所有数据
        ready: false,
        docProcess: [],
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
        processId: '',
        processNodeData: ''
    }


    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getProcess() {
                $.post('/gwspxt/getAllProcessNoPage', {}, function (response) {
                    data.docProcess = response;
                    data.ready = true;
                }, 'json')
            },
            transProcessId() {
                var pid = data.processId;
                console.log(pid);
                $.post('/gwspxt/getProNodeByPro', {processId: pid}, function (response) {
                    data.processNodeData = response;
                }, 'json');
            }
        },
        mounted() {
            this.getProcess({});
            $('#doucmentContent').summernote({
                height: 350, //set editable area's height
                codemirror: { // codemirror options
                    theme: 'monokai'
                },
                lang: 'zh-CN'
            });
            /*get&&set*
             * $('#doucmentContent').summernote('code')
             */
        },
        components: {
            'asideComponent': Layout,
            'sure-util': sureUtil
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });

    $('#addDoc').click(function () {
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
        if (!documentTitle) {
            spop({template: `标题不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentNo) {
            spop({template: `文本文号不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentType) {
            spop({template: `请选择文本类型`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentConfidential) {
            spop({template: `请选择文档密级`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentSpeed) {
            spop({template: `请选择文档级别`, style: "error", autoclose: 2000});
            return;
        }
        if (!doucmentContent) {
            spop({template: `文档内容不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentRemark) {
            spop({template: `备注不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentProcess) {
            spop({template: `请选择流程`, style: "error", autoclose: 2000});
            return;
        }
        $.ajax({
            type: "post",
            url: "/gwspxt/addDocument",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(data),
            success: function (data) {
                if (data) {

                    var documentId = data.documentId;
                    console.log(documentId);
                    $.ajax({
                        type: "post",
                        url: "/gwspxt/updateDocumentState",
                        dataType: "json",
                        data: JSON.stringify(data),
                        contentType: 'application/json;charset=UTF-8',
                        success: function (data) {
                            $.ajax({
                                type: "post",
                                url: "/gwspxt/messageNextOne",
                                dataType: "json",
                                data: {
                                    documentId: documentId,
                                },
                                success: function (data) {
                                    if (data.msg == 'updateSuccess') {
                                        spop({template: `提交成功`, style: "success", autoclose: 2000});
                                        window.location.href = "/gwspxt/documentManage";
                                    }

                                }
                            });

                        }
                    });
                } else {

                }
            }
        });

    });

    $('#addDraft').click(function () {
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
        if (!documentTitle) {
            spop({template: `标题不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentNo) {
            spop({template: `文本文号不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentType) {
            spop({template: `请选择文本类型`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentConfidential) {
            spop({template: `请选择文档密级`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentSpeed) {
            spop({template: `请选择文档级别`, style: "error", autoclose: 2000});
            return;
        }
        if (!doucmentContent) {
            spop({template: `文档内容不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentRemark) {
            spop({template: `备注不能为空`, style: "error", autoclose: 2000});
            return;
        }
        if (!documentProcess) {
            spop({template: `请选择流程`, style: "error", autoclose: 2000});
            return;
        }
        $.ajax({
            type: "post",
            url: "/gwspxt/addDocument",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(data),
            success: function (data) {
                spop({template: `以存入草稿`, style: "success", autoclose: 2000});
                window.location.href = "/gwspxt/documentManage";
            }
        });

    });

})