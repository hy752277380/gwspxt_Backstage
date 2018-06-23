$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        into_position: JSON.parse(sessionStorage.getItem('into_position')),
        name: 'positionManage',
        positionData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        modifyPositionData: {
            permission: {
                permissionId: 0,
                permissionLevel: 0,
                permissionRemark: ''
            },
            position: {
                positionId:0,
                positionDept:0,
                positionPermission:0,
                positionName:'',
                positionIsdelete:0,
            },
        },
        index: '',
        permissionData: [],
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },

        docDepartment: 0,
    }
    /*   表头的查询方法封装，暂未封装完全 */
    var searchUtil = Vue.extend({
        template: `<span role="presentation" class="dropdown">
                   <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">{{query.name}}<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                       <li v-for="item in query.items"><a href="javascript:;" :key="item.key">{{item.value}}</a></li>
                   </ul>
                   </span>`,
        props: ['query'],
    });


    var positionManage = new Vue({
        el: "#main",
        data: data,
        methods: {
            getPositionInfoById(department) {
                $.post('/gwspxt/getPoPeByDpt', department, function (response) {
                    data.positionData = response;

                }, 'json');
            },
            getPermission() {
                $.post('/gwspxt/getAllPermission', {}, function (response) {
                    data.permissionData = response;
                    positionManage.ready = true;
                }, 'json');
            },
            editPosition(index) {
                let posiData = data.positionData[index];
                data.modifyPositionData = posiData;
                console.log(data.modifyPositionData.permission.permissionId);
            },

            /*editDepartment(index) {
                var newDept = data.positionData[index];
                data.modifyPositionData = newDept;
               /!* $('#editModal').modal("show");*!/
            },*/

        },
        mounted() {
            this.getPositionInfoById({department: this.$data.into_position.dept_id});
            this.getPermission({});
            /* this.getPositionInfo({currentPage : 1});*/
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil
        }
    });
})