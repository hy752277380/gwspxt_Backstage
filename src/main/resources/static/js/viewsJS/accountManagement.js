$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'accountManagement',
        personData: [], //所有数据
        modalModifyPersonData: {
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
        modalAddPersonData: {
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
        searchData: {
            fuzzySearch: '',
        },
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
            getDepartmentOfPosition(action) {
                let dep = {};
                if (action == "modify") {
                    dep = data.modalModifyPersonData.userDepartment;
                } else if (action == "add") {
                    dep = data.modalAddPersonData.userDepartment;
                } else {
                    dep = null;
                }
                $.post('/gwspxt/getPoPeByDpt', {department: dep}, function (response) {
                    data.allDepartmentOfPosition = response;
                }, 'json');
            },
            modify(index) {
                data.modalModifyPersonData = data.personData[index].guser;
                this.getDepartmentOfPosition('modify');
                data.modalAction = false;
                $('#modalModify').modal('show');
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
                let person = data.modalAddPersonData;
                const that = this;
                $.post('/gwspxt/andUser', person, function (response) {
                    if (response.msg == "addSuccess") {
                        spop({template: `添加成功`, style: "success", autoclose: 2000});
                        $('#modalAdd').modal('hide');
                        that.getInfo({currentPage: data.page.currentPage})
                    }
                    else if (response.msg == "addFailed") {
                        spop({template: `添加失败`, style: "error", autoclose: 2000});
                    } else if (response.msg == "accountExist") {
                        spop({template: `员工编号已存在`, style: "error", autoclose: 2000});
                    }
                }, 'json');
            },
            modalModify() {
                let person = data.modalModifyPersonData;
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
            $('#modalAdd').on('hidden.bs.modal', function () {
                for (let item in data.modalAddPersonData) {
                    data.modalAddPersonData[item] = '';
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