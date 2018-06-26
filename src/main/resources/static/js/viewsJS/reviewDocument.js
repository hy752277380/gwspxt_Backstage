$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'reviewDocument',
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
        docType: {
            name: "文档类型",
            items: [
                {key: "", value: "全部"},
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
                {key: "14", value: "其他"},
            ],
        },
        docConfidential: {
            name: "文档密级",
            items: [
                {key: "0", value: "所有"},
                {key: "1", value: "绝密"},
                {key: "2", value: "机密"},
                {key: "3", value: "秘密"},
                {key: "4", value: "普通"},
            ],
        },
        docDepartment: 0,
        searchData: {
            documentType: '',
            documentConfidential: 0,
            documentState: 0,
            fuzzySearch: '',
        },
        applyReason: '',
        applyIndex: 0
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            /* 选择所有，可以缺少 */
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
            /* 获取数据 */
            getInfo(params) {
                $.post('/gwspxt/getAllDocument', params, function (response) {
                    reviewDocument.docData = response.list;
                    reviewDocument.page.currentPage = response.currentPage;
                    reviewDocument.page.totalPage = response.totalPage;
                    reviewDocument.page.allRow = response.allRow;
                    reviewDocument.page.currentPage = response.currentPage;
                    reviewDocument.page.hasPreviousPage = response.hasPreviousPage;
                    reviewDocument.page.hasNextPage = response.hasNextPage;
                    reviewDocument.ready = true;
                }, 'json');
            },
            /* 密级数字到标签的替换 */
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
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getInfo({
                    currentPage: pageIndex,
                    documentType: data.searchData.documentType,
                    documentConfidential: data.searchData.documentConfidential,
                    documentState: data.searchData.documentState,
                    fuzzySearch: data.searchData.fuzzySearch
                });
            },
            applyBorrowingModal() {

            },
            /*申请借阅事件*/
            applyBorrowing() {
                let that = this;
                let documentCustom = this.$data.docData[data.applyIndex];
                documentCustom.borrowing = {borrowingReason: data.applyReason};
                $.ajax({
                    type: "post",
                    url: "/gwspxt/applyRead",
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(documentCustom),
                    success: function (response) {
                        if (response.msg == "updateSuccess") {
                            that.getInfo({currentPage: 1})
                            spop({
                                template: `已发出您对${documentCustom.document.documentTitle}的借阅申请`,
                                style: "success",
                                autoclose: 2000
                            });
                        } else if (response.msg == "updateFailed") {
                            spop({template: `申请失败`, style: "error", autoclose: 2000});
                        }
                    }
                })
                /* let documentCustom = this.$data.docData[index];
                 $.post('/gwspxt/applyRead', {documentCustom: documentCustom}, function (response) {
                     if (response.msg == "updateSuccess") {
                         spop({
                             template: `已发出您对${documentCustom.document.documentTitle}的借阅申请`,
                             style: "success",
                             autoclose: 2000
                         });
                     } else if (response.msg == "updateFailed") {
                         spop({template: `申请失败`, style: "error", autoclose: 2000});
                     }
                 }, 'json');*/
            },
            reviewDocument(index) {
                var lhs_edit = {"doc_id": this.docData[index].document.documentId}
                sessionStorage.setItem('lhs_edit', JSON.stringify(lhs_edit));
                location.href = "/gwspxt/reviewContent";
            },
            search(msg) {
                data.searchData[msg.searchName] = msg.key;
                this.getInfo({
                    currentPage: 1,
                    documentType: data.searchData.documentType,
                    documentConfidential: data.searchData.documentConfidential,
                    documentState: data.searchData.documentState,
                    fuzzySearch: data.searchData.fuzzySearch
                })
            },
        },
        mounted() {
            this.getInfo({currentPage: 1});
            $('#ApplyReasonModal').on('hidden.bs.modal', function () {
                data.applyReason = '';
            });
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil,
            'sure-util': sureUtil
        }
    });
})