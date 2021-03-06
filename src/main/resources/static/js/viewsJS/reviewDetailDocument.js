$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        lhs_edit: JSON.parse(sessionStorage.getItem('lhs_edit')),
        name: 'documentManage',
        docData: {
            document: {
                documentId: "",
                documentTitle: "",
                documentType: "1",
                documentNo: "",
                documentDept: "1",
                documentConfidential: 0,
                doucmentContent: "",
                documentRemark: "",
                documentProcess: 0,
                documentLocation: 0,
                documentState: 0,
                documentSpeed: 0,
            },
            documenttype: {
                documenttypeName: "命令",
            },
            department: {
                departmentName: "办公室",
            },
            guser: {
                userName: "江南",
            },
        }, //所有数据
        docType: [],
        docProcess: [],
        processNode: [],
        ready: false,
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        }
    }


    var reviewDetailDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getInfo(documentId) {
                var that = this;
                $.post('/gwspxt/documentBaseInfo', documentId, function (response) {
                    data.docData = response;
                    $('#doucmentContent').summernote('code',data.docData.document.doucmentContent);
                    $('.documentDetailContent').summernote('code',data.docData.document.doucmentContent);
                    $('.documentDetailContent').summernote('destroy');
                    that.getProcessNode();
                }, 'json');
            },
            getDocType() {
                $.post('/gwspxt/getAllDocType', {}, function (response) {
                    data.docType = response;
                }, 'json');
            },
            getProcess() {
                $.post('/gwspxt/getAllProcessNoPage', {}, function (response) {
                    data.docProcess = response;
                }, 'json')
            },
            getProcessNode() {
                $.post('/gwspxt/getProNodeByPro', {processId: data.docData.document.documentProcess}, function (response) {
                    data.processNode = response;
                }, 'json');
            },
        },
        mounted() {
            console.log(data.lhs_edit.doc_id)
            this.getInfo({documentId: this.$data.lhs_edit.doc_id});
            this.getDocType();
            this.getProcess();
            $('#doucmentContent').summernote({
                height: 350, //set editable area's height
                codemirror: { // codemirror options
                    theme: 'monokai'
                },
                lang: 'zh-CN'
            });
            $(".documentDetailContent").summernote({
                height: 500,
                toolbar: false,
                hint: {
                    mentions: ['jayden', 'sam', 'alvin', 'david'],
                    match: /\B@(\w*)$/,
                    search: function (keyword, callback) {
                        callback($.grep(this.mentions, function (item) {
                            return item.indexOf(keyword) == 0;
                        }));
                    },
                    content: function (item) {
                        return '@' + item;
                    }
                }
            });
            /*get&&set*
             * $('#doucmentContent').summernote('code')
             */
        },
        components: {
            'asideComponent': Layout,
        },
    })
})
