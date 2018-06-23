$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        into_processNode: JSON.parse(sessionStorage.getItem('into_processNode')),
        name: 'positionManage',
        processNodeData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        departmentData: [],
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
            getProcessNodeInfoById(param) {
                $.post('/gwspxt/getProNodeByPro', param, function (response) {
                    data.processNodeData = response;
                    data.ready = true;
                }, 'json');
            },
            getdepartment() {
                $.post('/gwspxt/getAllDepartmentNoPage', {}, function (response) {
                    data.departmentData = response;
                    data.ready = true;
                }, 'json');
            },
            editPosition(index) {
                let posiData = data.processNodeData[index];
                data.modifyprocessNodeData = posiData;
                console.log(data.modifyprocessNodeData.permission.permissionId);
            },
        },
        mounted() {
            this.getProcessNodeInfoById({processId: data.into_processNode.process_id});
            this.getdepartment({});
            /* this.getPositionInfo({currentPage : 1});*/
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil
        }
    });
})