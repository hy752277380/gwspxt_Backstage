$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'departmentMemberManage',
        personData: '', //所有数据
        ready: false,
        allocatePerson: {
            userAccount: '',
            userPassword: '',
            userName: '',
            userSex: '',
            userDepartment: '',
            userPosition: '',
            userPhonenumber: '',
            userEmail: '',
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
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            /* 获取数据 */
            getInfo(params) {
                $.post('/gwspxt/getUserByDpt', params, function (response) {
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