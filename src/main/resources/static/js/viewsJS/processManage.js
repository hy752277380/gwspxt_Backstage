$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'processManagement',
        processData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        processModalData: '',
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
        searchData: {
            fuzzySearch: '',
        },
        docDepartment: 0,
    }

    var processManage = new Vue({
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
            getProcessInfo(params) {
                $.post('/gwspxt/getAllProcess', params, function (response) {
                    processManage.processData = response.list;
                    processManage.page.currentPage = response.currentPage;
                    processManage.page.totalPage = response.totalPage;
                    processManage.page.allRow = response.allRow;
                    processManage.page.currentPage = response.currentPage;
                    processManage.page.hasPreviousPage = response.hasPreviousPage;
                    processManage.page.hasNextPage = response.hasNextPage;
                    processManage.ready = true;
                }, 'json');
            },
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getProcessInfo({
                    currentPage: pageIndex,
                    fuzzySearch: data.searchData.fuzzySearch
                });
            },
            editProgress(index) {
                var newProgress = data.processData[index];
                data.processModalData = newProgress;
                console.log(data.processModalData.processId);
                /* $('#editModal').modal("show");*/
            },
            intoProgressNode(index) {
                var into_processNode = {
                    lhs_process: this.processData[index].processName,
                    process_id: this.processData[index].processId,
                }
                sessionStorage.setItem('into_processNode', JSON.stringify(into_processNode));
                location.href = "/gwspxt/processNode";
            },
            deleteBatchProcess() {
                let arrId = [];
                $('input[name="checkId"]').each(function () {
                    if ($(this).attr('checked')) {
                        arrId.push($(this).attr('process-id'));
                    }

                });
                $('input[checked="checked"]:checkbox').each(function () {
                    $(this).removeAttr('checked');
                });
                $.post('/gwspxt/deleteProcess', {ids: arrId}, response => {
                    if (response.msg == "updateSuccess") {
                        this.getProcessInfo({currentPage: 1});
                        spop({template: `删除成功`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `删除失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');

            },
            deleteProcess(index) {
                let processId = data.processData[index].processId;
                let that = this;
                $.post('/gwspxt/deleteProcess', {ids: [processId]}, function (response) {
                    if (response.msg == "updateSuccess") {
                        that.getProcessInfo({currentPage: 1});
                        spop({template: `删除成功`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `删除失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
            search(msg) {
                data.searchData[msg.searchName] = msg.key;
                this.getProcessInfo({
                    currentPage: 1,
                    fuzzySearch: data.searchData.fuzzySearch
                })
            },
        },
        mounted() {
            this.getProcessInfo({
                currentPage: 1,
                fuzzySearch: data.searchData.fuzzySearch
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