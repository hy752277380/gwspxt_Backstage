$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'approvalApplication',
        docData: '', //所有数据
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
    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            //'search-util': searchUtil
        },
        methods: {
            getInfo(params) {
                $.post('/gwspxt/getAllApplyRead', params, function (response) {
                    data.docData = response.list;
                    data.page.currentPage = response.currentPage;
                    data.page.totalPage = response.totalPage;
                    data.page.allRow = response.allRow;
                    data.page.currentPage = response.currentPage;
                    data.page.hasPreviousPage = response.hasPreviousPage;
                    data.page.hasNextPage = response.hasNextPage;
                    data.ready = true;
                }, 'json');
            },
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getInfo({currentPage: pageIndex});
            },
            accept(index) {
                let documentCustom = this.$data.docData[index];
                $.post('/gwspxt/getAllApplyRead', {documentCustom: documentCustom}, function (response) {
                    if (response.msg == "updateSuccess") {
                        spop({template: `已同意${documentCustom.guser.userName}对${documentCustom.document.documentTitle}的借阅`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `同意失败,同部门其他成员已经处理改请求`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
            refuse(index) {
                let documentCustom = this.$data.docData[index];
                $.post('/gwspxt/refuseApply', {documentCustom: documentCustom}, function (response) {
                    if (response.msg == "updateSuccess") {
                        spop({template: `已拒绝${documentCustom.guser.userName}对${documentCustom.document.documentTitle}的借阅`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `拒绝失败,同部门其他成员已经处理改请求`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
        },
        mounted() {
            this.getInfo({currentPage: 1});
        },
    });
})