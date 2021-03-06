$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'departmentMemberManage',
        docData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        reviewPersonId: sessionStorage.getItem("reviewPersonId"),
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
                {key: "0", value: "全部"},
                {key: "1", value: "命令"},
                {key: "2", value: "批复"},
                {key: "3", value: "意见"},
                {key: "4", value: "函"},
                {key: "5", value: "会议纪要"},
                {key: "6", value: "决定"},
                {key: "7", value: "公告"},
                {key: "8", value: "通告"},
                {key: "9", value: "通知"},
                {key: "10", value: "通报"},
                {key: "11", value: "议案"},
                {key: "12", value: "报告"},
                {key: "13", value: "请示"},
            ],
        },
        docConfidential: {
            name: "文档密级",
            items: [
                {key: "0", value: "全部"},
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
                    documentManage.docData = response.list;
                    documentManage.page.currentPage = response.currentPage;
                    documentManage.page.totalPage = response.totalPage;
                    documentManage.page.allRow = response.allRow;
                    documentManage.page.currentPage = response.currentPage;
                    documentManage.page.hasPreviousPage = response.hasPreviousPage;
                    documentManage.page.hasNextPage = response.hasNextPage;
                    documentManage.ready = true;
                }, 'json');
            },
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getInfo({currentPage: pageIndex, userId: data.reviewPersonId});
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
                    case 1:
                        return "<span class=\"label label-danger\">退回</span>";
                    case 2:
                        return "<span class=\"label label-default\">草稿</span>";
                    case 3:
                        return "<span class=\"label label-warning\">待审核</span>";
                    case 4:
                        return "<span class=\"label label-primary\">审核中</span>";
                    case 5:
                        return "<span class=\"label label-info\">已审核</span>";
                    case 6:
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
                    "action": "checkPerson",
                    "doc_id": this.docData[index].document.documentId
                }
                sessionStorage.setItem('lhs_edit', JSON.stringify(lhs_check));
                window.location.href = "/gwspxt/reviewContent";
            },
        },
        mounted() {
            this.getInfo({currentPage: 1, userId: data.reviewPersonId});
        },
        watch: {},
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil,
        }
    });
})