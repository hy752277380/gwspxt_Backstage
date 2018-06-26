$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'deptManage',
        deptData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        modifyModalData: '',
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

    var deptManage = new Vue({
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
            getDeptInfo(params) {
                $.post('/gwspxt/getAllDepartment', params, function (response) {
                    data.deptData = response.list;
                    data.page.currentPage = response.currentPage;
                    data.page.totalPage = response.totalPage;
                    data.page.allRow = response.allRow;
                    data.page.currentPage = response.currentPage;
                    data.page.hasPreviousPage = response.hasPreviousPage;
                    data.page.hasNextPage = response.hasNextPage;
                    data.ready = true;
                }, 'json');
            },
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getDeptInfo({currentPage: pageIndex});
            },
            editDepartment(index) {
                var newDept = data.deptData[index];
                data.modifyModalData = newDept;
                /* $('#editModal').modal("show");*/
            },
            intoPosition(index) {
                var into_position = {
                    "lhs_dept": this.deptData[index].departmentName,
                    "dept_id": this.deptData[index].departmentId,
                }
                sessionStorage.setItem('into_position', JSON.stringify(into_position));
                location.href = "/gwspxt/departmentPosition";
            },
            search(msg) {
                data.searchData[msg.searchName] = msg.key;
                this.getInfo({
                    currentPage: 1,
                    fuzzySearch: data.searchData.fuzzySearch
                })
            },
        },
        mounted() {
            this.getDeptInfo({currentPage: 1});
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil
        }
    });
})