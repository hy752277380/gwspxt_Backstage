$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'processManage',
        processData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index:'',
        processMoalData:'',
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
            editDepartment(index) {
                var newDept = data.processData[index];
                data.processMoalData = newDept;
               /* $('#editModal').modal("show");*/
            },
            intoPosition(index){
                var into_position = {
                    "lhs_dept":this.processData[index].departmentName,
                    "dept_id": this.processData[index].departmentId,
                }
                sessionStorage.setItem('into_position', JSON.stringify(into_position));
                location.href = "/gwspxt/departmentPosition";
            },

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