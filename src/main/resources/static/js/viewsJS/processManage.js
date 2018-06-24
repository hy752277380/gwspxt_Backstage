$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'processManage',
        processData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index:'',
        processModalData:'',
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
                this.getProcessInfo({currentPage: pageIndex});
            },
            editProgress(index) {
                var newProgress = data.processData[index];
                data.processModalData = newProgress;
                console.log(data.processModalData.processId);
               /* $('#editModal').modal("show");*/
            },
            intoProgressNode(index){
                var into_processNode = {
                    lhs_process:this.processData[index].processName,
                    process_id: this.processData[index].processId,
                }
                sessionStorage.setItem('into_processNode', JSON.stringify(into_processNode));
                location.href = "/gwspxt/processNode";
            },
           /* deleteProcess(index){
                var processId=data.processData[index].processNodeData;
                console.log(processId);
                $.post('/gwspxt/deleteProcess',{processId:processId}, function (response) {
                }, 'json');
            }
*/
        },
        mounted() {
            this.getProcessInfo({currentPage: 1});
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil
        }
    });
})