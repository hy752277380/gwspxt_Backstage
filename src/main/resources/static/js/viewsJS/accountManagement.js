$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'accountManagement',
        personData: [], //所有数据
        modalPersonData: {
            userId: '',
            userAccount: '',
            userPassword: '',
            userName: '',
            userSex: '',
            userDepartment: '',
            userPosition: '',
            userPhonenumber: '',
            userEmail: '',
            userIntroduction: '',
            userPicture: '',
            creationTime: '',
            userIsdelete: ''
        },
        modalAction: true,
        allDepartment: [],
        allDepartmentOfPosition: {},
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
                $.post('/gwspxt/getAllUser', params, function (response) {
                    reviewDocument.personData = response.list;
                    reviewDocument.page.currentPage = response.currentPage;
                    reviewDocument.page.totalPage = response.totalPage;
                    reviewDocument.page.allRow = response.allRow;
                    reviewDocument.page.currentPage = response.currentPage;
                    reviewDocument.page.hasPreviousPage = response.hasPreviousPage;
                    reviewDocument.page.hasNextPage = response.hasNextPage;
                    reviewDocument.ready = true;
                }, 'json');
            },
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getInfo({currentPage: pageIndex});
            },
            getAllDepartment() {
                let that = this;
                $.post('/gwspxt/getAllDepartmentNoPage', {}, function (response) {
                    data.allDepartment = response;
                    that.getDepartmentOfPosition();
                }, 'json');
            },
            getDepartmentOfPosition() {
                $.post('/gwspxt/getPoPeByDpt', {department: data.modalPersonData.userDepartment}, function (response) {
                    data.allDepartmentOfPosition = response;
                }, 'json');
            },
            modify(index) {
                let that = this;
                data.modalPersonData = data.personData[index].guser;
                that.getDepartmentOfPosition();
                data.modalAction = false;
                $('#myModal').modal('show');
            },
            deleteP(index) {
                let person = data.personData[index].guser;
                const that = this;
                $.post('/gwspxt/batchDelete', {userIds: [person.userId]}, function (response) {
                    if (response.msg == "updateSuccess") {
                        spop({template: `删除成功`, style: "success", autoclose: 2000});
                        that.getInfo({currentPage: data.page.currentPage})
                    }
                    else if (response.msg == "updateFailed") {
                        spop({template: `删除失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
            reset(index) {
                let person = data.personData[index].guser;
                const that = this;
                $.post('/gwspxt/resetPassword', {userId: person.userId}, function (response) {
                    if (response.msg == "updateSuccess") {
                        spop({template: `重置成功`, style: "success", autoclose: 2000});
                        that.getInfo({currentPage: data.page.currentPage})
                    }
                    else if (response.msg == "updateFailed") {
                        spop({template: `重置失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
            modalAdd() {
                let person = data.modalPersonData;
                const that = this;
                $.post('/gwspxt/andUser', person, function (response) {
                    if (response.msg == "updateSuccess") {
                        spop({template: `添加成功`, style: "success", autoclose: 2000});
                        that.getInfo({currentPage: data.page.currentPage})
                    }
                    else if (response.msg == "updateFailed") {
                        spop({template: `添加失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
            modalModify() {
                let person = data.modalPersonData;
                const that = this;
                $.ajax({
                    type: "POST",
                    url: '/gwspxt/updateUserinfo',
                    data: JSON.stringify(person),
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: function (response) {
                        if (response.msg == "updateSuccess") {
                            spop({template: `修改成功`, style: "success", autoclose: 2000});
                            that.getInfo({currentPage: data.page.currentPage})
                        }
                        else if (response.msg == "updateFailed") {
                            spop({template: `修改失败`, style: "error", autoclose: 2000});
                        }
                    }
                });
               /* $.post('/gwspxt/updateUserinfo', person, function (response) {
                    if (response.msg == "updateSuccess") {
                        spop({template: `修改成功`, style: "success", autoclose: 2000});
                        that.getInfo({currentPage: data.page.currentPage})
                    }
                    else if (response.msg == "updateFailed") {
                        spop({template: `修改失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');*/
            }
        },
        mounted() {
            this.getInfo({currentPage: 1});
            this.getAllDepartment();
            $('#myModal').on('hidden.bs.modal', function () {
                for (let item in data.modalPersonData) {
                    data.modalPersonData.item = '';
                }
            })
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            //'search-util': searchUtil
            'sure-util': sureUtil
        }
    });
})