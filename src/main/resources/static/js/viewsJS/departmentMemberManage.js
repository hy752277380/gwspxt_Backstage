$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'departmentMemberManage',
        personData: '', //所有数据
        ready: false,
        allocatePerson: {
            userId: "",
            userAccount: "",
            userPassword: "",
            userName: "",
            userSex: 1,
            userDepartment: "",
            userPosition: "",
            userPhonenumber: "",
            userEmail: "",
        },
        allDepartment: [],
        allDepartmentOfPosition: [],
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
        }
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            /* 获取数据 */
            getInfo(params) {
                $.post('/gwspxt/getUserByDpt', params, function (response) {
                    data.personData = response.list;
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
                this.getInfo({currentPage: pageIndex});
            },
            reviewJournal(index) {
                const personID = this.personData[index].guser.userId;
                sessionStorage.setItem('reviewPersonId', personID);
                window.location.href = "/gwspxt/reviewPersonJournal";
            },
            reviewDocument(index) {
                const personID = this.personData[index].guser.userId;
                sessionStorage.setItem('reviewPersonId', personID);
                window.location.href = "/gwspxt/reviewPersonDocument";
            },
            allocate(index) {
                const personID = this.personData[index].guser.userId;
                $.post('/gwspxt/getUserById', {userId: personID}, function (response) {
                    data.allocatePerson = response;
                    /*再通过部门ID去获取，部门内的全部职称*/
                    $.post('/gwspxt/getPoPeByDpt', {department: response.userDepartment}, function (response) {
                        data.allDepartmentOfPosition = response;
                    }, 'json');
                    $('#allocateModal').modal('show');
                }, 'json');
            },
            getAllDepartment() {
                $.post('/gwspxt/getAllDepartmentNoPage', {}, function (response) {
                    data.allDepartment = response;
                }, 'json');
            },
            getDepartmentOfPosition() {
                $.post('/gwspxt/getPoPeByDpt', {department: data.allocatePerson.userDepartment}, function (response) {
                    data.allDepartmentOfPosition = response;
                }, 'json');
            },
            saveModify() {
                $.ajaxSetup({'Content-Type': 'application/json;charset=utf-8',});
                $.ajax({
                    type: "POST",
                    url: '/gwspxt/updatePersonInfo',
                    data: JSON.stringify(data.allocatePerson),
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: function (response) {
                        if (response.msg == "updateSuccess") {
                            spop({template: `调配成功`, style: "success", autoclose: 2000});
                        } else if (response.msg == "updateFailed") {
                            spop({template: `调配失败`, style: "error", autoclose: 2000});
                        }
                    }
                });
                /*$.post('/gwspxt/updatePersonInfo', JSON.stringify(data.allocatePerson), function (response) {}, 'json');*/
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
            this.getInfo({currentPage: 1});
            this.getAllDepartment();
            /*/!*清空数据*!/
            $('#allocateModal').on('hidden.bs.modal', function (e) {
                for (let item in data.allocatePerson) {
                    data.allocatePerson.item = '',
                }
            })*/
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });

})