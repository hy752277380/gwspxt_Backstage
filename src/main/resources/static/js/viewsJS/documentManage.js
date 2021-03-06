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
                {key: "", value: "全部"},
                {key: "1", value: "命令"},
                {key: "2", value: "决定"},
                {key: "3", value: "公告"},
                {key: "4", value: "通告"},
                {key: "5", value: "通知"},
                {key: "6", value: "通报"},
                {key: "7", value: "议案"},
                {key: "8", value: "报告"},
                {key: "9", value: "请示"},
                {key: "10", value: "批复"},
                {key: "11", value: "意见"},
                {key: "12", value: "函"},
                {key: "13", value: "会议纪要"},
                {key: "14", value: "其他"},
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
        docState: {
            name: "文档状态",
            items: [
                {key: "0", value: "全部"},
                {key: "1", value: "退回"},
                {key: "2", value: "草稿"},
                {key: "3", value: "待审核"},
                {key: "4", value: "审核中"},
                {key: "5", value: "已审核"},
                {key: "6", value: "已归档"},
            ],
        },
        docDepartment: 0,
       /* department:[],
        docDepartment: {
            name:"拟稿部门",
            items: [
                /!* {key: "", value: ""},*!/
            ],

        },*/
        searchData: {
            documentType: '',
            documentConfidential: 0,
            documentState: 0,
            fuzzySearch: '',
            documentDept:''
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
            returnDocument(index){
           /*callBack*/
                let docId = data.docData[index].document.documentId;
                $.post('/gwspxt/callBack', {documentId:docId}, response=>{
                    if (response.msg == "updateSuccess") {
                        this.getInfo({currentPage: 1});
                        spop({template: `退回成功`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `退回失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');
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
                console.log(docId),
                    $.post('/gwspxt/deleteDoc', {ids: [docId]}, function (response) {
                        if (response.msg == "updateSuccess") {
                            that.getInfo({currentPage: 1});
                            spop({template: `删除成功`, style: "success", autoclose: 2000});
                        } else if (response.msg == "updateFailed") {
                            spop({template: `删除失败`, style: "error", autoclose: 2000});
                        }
                    }, 'json');
            },
           /* getDepartment() {
                $.post('/gwspxt/getAllDepartmentNoPage', {}, function (response) {
                    data.department=response;
                    let arr = [{key:'',value:'全部'}];
                    for(var dept in response){
                        let lhs = {
                            key:data.department[dept].departmentId,
                            value:data.department[dept].departmentName
                        };
                        arr.push(lhs);
                    }
                    data.docDepartment.items = arr;
                }, 'json');
            },*/
          /*  deleteBatchDocument() {
                let arrId = [];
                $('input[name="checkID"]').each(function () {
                    if ($(this).attr('checked')) {
                        arrId.push($(this).attr('doc-id'));
                    }

                });
                $('input[checked="checked"]:checkbox').each(function () {
                    $(this).removeAttr('checked');
                });
                $.post('/gwspxt/deleteDoc', {ids: arrId}, response => {
                        if (response.msg == "updateSuccess") {
                            this.getInfo({currentPage: 1});
                            spop({template: `删除成功`, style: "success", autoclose: 2000});
                        } else if (response.msg == "updateFailed") {
                            spop({template: `删除失败`, style: "error", autoclose: 2000});
                        }
                    }
                    ,
                    'json'
                )
                ;

            },*/
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getInfo({
                    currentPage: pageIndex,
                    documentType: data.searchData.documentType,
                    documentConfidential: data.searchData.documentConfidential,
                    documentState: data.searchData.documentState,
                    fuzzySearch: data.searchData.fuzzySearch,
                    documentDept:data.searchData.documentDept
                });
            },
            search(msg) {
                data.searchData[msg.searchName] = msg.key;
                this.getInfo({
                    currentPage: 1,
                    documentType: data.searchData.documentType,
                    documentConfidential: data.searchData.documentConfidential,
                    documentState: data.searchData.documentState,
                    fuzzySearch: data.searchData.fuzzySearch,
                    documentDept:data.searchData.documentDept
                })

            },
        },
        mounted() {
            this.getInfo({currentPage: 1});
           /* this.getDepartment();*/
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil,
            'sure-util': sureUtil,
        }
    });
})