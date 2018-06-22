
$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        lhs_edit: JSON.parse(sessionStorage.getItem('lhs_edit')),
        name: 'reviewDetailDocument',
        docData: {}, //所有数据
        docType: [],
        docProcess: [],
        ready: false,
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
    }


    var reviewDetailDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getInfo(documentId) {
                $.post('/gwspxt/documentBaseInfo', documentId, function (response) {
                    data.docData = response;
                }, 'json');
            },
            getDocType() {
                $.post('/gwspxt/getAllDocType', {}, function (response) {
                    data.docType = response;
                }, 'json');
            },
            getProcess() {
                $.post('/gwspxt/getAllProcess', {}, function (response) {
                    data.docProcess = response;
                    data.ready = true;
                }, 'json')
            }
        },


        mounted() {
            this.getInfo({documentId: this.$data.lhs_edit.doc_id});
            this.getDocType({});
            this.getProcess({});
        },
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        },

    })



})
