$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        into_processNode: JSON.parse(sessionStorage.getItem('into_processNode')),
        name: 'positionManage',
        processNodeData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        departmentData: '',
        posPermiData: [
            {
                position: {
                    positionId: '',
                    positionDept: '',
                    positionPermission: '',
                    positionName: '',
                    positionIsdelete: 0,
                },
                permission: {
                    permissionId: '',
                    permissionLevel: '',
                    permissionRemark: '',
                }
            }

        ],
        positionData: '',
        page:
            {
                allRow: 1,
                totalPage: 1,
                currentPage: 1,
                pageSize: 10,
                hasPreviousPage: false,
                hasNextPage: false,
            }
        ,
        processNode: {
            processNodeProcess: '',
            processNodeName: "",
            processNodeDepartment: "",
            processNodePosition: ""
        }
    }

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
                }, 'json');
            },
            getDeptPosition() {
                var deptId = data.processNode.processNodeDepartment;
                $.post('/gwspxt/getPoPeByDpt', {department: deptId}, function (response) {
                    data.posPermiData = response;
                }, 'json');

            },
            addProcessNode() {
                $.ajax({
                    type: "post",
                    url: "/gwspxt/addProcessNode",
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(data.processNode),
                    success: function (response){}})
            },
            deleteProcessNode(index){
                var processNodeId=data.processNodeData[index].process_node.processNodeId;
                console.log(processNodeId);
                $.post('/gwspxt/deleteProcessNode',{processNodeId:processNodeId}, function (response) {
                }, 'json');
            }
        },
        mounted() {
            this.getProcessNodeInfoById({processId: data.into_processNode.process_id});
            this.getdepartment({});
            data.processNode.processNodeProcess = data.into_processNode.process_id;
        },
        components: {
            'asideComponent': Layout,
        }
    });

})