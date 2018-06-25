$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'documentManage',
        docData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
        docType: {
            name: "文档类型",
            items: [
                {key: "命令", value: "命令"},
                {key: "批复", value: "批复"},
                {key: "意见", value: "意见"},
                {key: "函", value: "函"},
                {key: "会议纪要", value: "会议纪要"},
                {key: "决定", value: "决定"},
                {key: "公告", value: "公告"},
                {key: "通告", value: "通告"},
                {key: "通知", value: "通知"},
                {key: "通报", value: "通报"},
                {key: "议案", value: "议案"},
                {key: "报告", value: "报告"},
                {key: "请示", value: "请示"},
            ],
        },
        docConfidential: {
            name: "文档密级",
            items: [
                {key: "1", value: "绝密"},
                {key: "2", value: "机密"},
                {key: "3", value: "秘密"},
                {key: "4", value: "普通"},
            ],
        },
        documentState: {
            name: "文档状态",
            items: [
                {key: "0", value: "退回"},
                {key: "1", value: "草稿"},
                {key: "2", value: "待审核"},
                {key: "3", value: "审核中"},
                {key: "4", value: "已审核"},
                {key: "5", value: "已归档"},
            ],
        },
        docDepartment: 0,
    }

    var documentManage = new Vue({
        el: "#main",
        data: data,
        methods: {
            checkAll($event) {
                if ($event.target.checked) {
                    $('input[check="self"]').each(function () {
                        $(this).prop("checked", true);
                    });
                } else {
                    $('input[check="self"]').each(function () {
                        $(this).prop("checked", false);
                    });
                }
            },
            getInfo(params) {
                $.post('/gwspxt/getDocumentByState', params, function (response) {
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
            replaceConfidential(documentConfidential) {
                switch (documentConfidential) {
                    case 1:
                        return "<span class=\"label label-danger\">绝密</span>";
                    case 2:
                        return "<span class=\"label label-warning\">机密</span>";
                    case 3:
                        return "<span class=\"label label-info\">秘密</span>";
                    case 4:
                        return "<span class=\"label label-primary\">普通</span>";
                }
            },
            replaceState(documentState) {
                switch (documentState) {
                    case 0:
                        return "<span class=\"label label-danger\">退回</span>";
                    case 1:
                        return "<span class=\"label label-default\">草稿</span>";
                    case 2:
                        return "<span class=\"label label-warning\">待审核</span>";
                    case 3:
                        return "<span class=\"label label-primary\">审核中</span>";
                    case 4:
                        return "<span class=\"label label-info\">已审核</span>";
                    case 5:
                        return "<span class=\"label label-success\">已归档</span>";
                }
            },
            editDocument(index) {
                var lhs_edit = {
                    "action": "edit",
                    "doc_id": this.docData[index].document.documentId
                }
                sessionStorage.setItem('lhs_edit', JSON.stringify(lhs_edit));
                location.href = "/gwspxt/reviewDetailDocument";
            },
            checkDocument(index) {
                var lhs_check = {
                    "action": "check",
                    "doc_id": this.docData[index].document.documentId
                }
                sessionStorage.setItem('lhs_edit', JSON.stringify(lhs_check));
                window.location.href = "/gwspxt/reviewDetailDocument";
            },
            deleteDocument(index) {
                let docId = data.docData[index].document.documentId;
                let that = this;
                let ids = [];
                ids.push(docId)
                $.post('/gwspxt/deleteDoc', JSON.stringify({ids: ids}), function (response) {
                    if (response.msg == "updateSuccess") {
                        that.getInfo({currentPage: 1});
                        spop({template: `删除成功`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `删除失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            }
        },
        mounted() {
            this.getInfo({currentPage: 1});
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil,
            'sure-util': sureUtil,
        }
    });
})