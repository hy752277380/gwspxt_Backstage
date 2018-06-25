$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        into_processNode: JSON.parse(sessionStorage.getItem('into_processNode')),
        name: 'processNodeManage',
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

    var processNodeManage = new Vue({
        el: "#main",
        data: data,
        methods: {
            getProcessNodeInfoById(processId) {
                $.post('/gwspxt/getProNodeByPro', processId, function (response) {
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
                    success: function (res) {
                    }
                    })
            },
            deleteProcessNode(index) {
                var processNodeId = data.processNodeData[index].process_node.processNodeId;
                console.log(processNodeId);
                $.post('/gwspxt/deleteProcessNode', {processNodeId: processNodeId}).then(function (response) {
                    processNodeManage.$options.methods.getProcessNodeInfoById({processId: data.into_processNode.process_id});
                }, 'json');

                /* let docId = data.docData[index].document.documentId;
                let that = this;
                $.post('/gwspxt/deleteDoc', {ids: [docId]}, function (response) {
                    if (response.msg == "updateSuccess") {
                        that.getInfo({currentPage: 1});
                        spop({template: `删除成功`, style: "success", autoclose: 2000});
                    } else if (response.msg == "updateFailed") {
                        spop({template: `删除失败`, style: "error", autoclose: 2000});
                    }
                }, 'json');*/
            }
        },
        mounted() {
            this.getProcessNodeInfoById({processId: data.into_processNode.process_id});
            this.getdepartment({});
            data.processNode.processNodeProcess = data.into_processNode.process_id;
        },
        components: {
            'asideComponent': Layout,
            'sure-util': sureUtil,
        }
    });

})