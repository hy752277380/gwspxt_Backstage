$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'deptManage',
        deptData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index:'',
        modifyModalData:'',
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


    var deptManage = new Vue({
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
            getDeptInfo(params) {
                $.post('/gwspxt/getAllDepartment', params, function (response) {
                    deptManage.deptData = response.list;
                    deptManage.page.currentPage = response.currentPage;
                    deptManage.page.totalPage = response.totalPage;
                    deptManage.page.allRow = response.allRow;
                    deptManage.page.currentPage = response.currentPage;
                    deptManage.page.hasPreviousPage = response.hasPreviousPage;
                    deptManage.page.hasNextPage = response.hasNextPage;
                    deptManage.ready = true;
                }, 'json');
            },
            /* 页码改变时候触发的事件，不可缺少 */
            change(pageIndex) {
                this.$data.page.currentPage = pageIndex;
                this.getDeptInfo({currentPage: pageIndex});
            },
            editDepartment(index) {
                var newDept = data.deptData[index];
                data.modifyModalData = newDept;
               /* $('#editModal').modal("show");*/
            },
            intoPosition(index){
                var into_position = {
                    "lhs_dept":this.deptData[index].departmentName,
                    "dept_id": this.deptData[index].departmentId,
                }
                sessionStorage.setItem('into_position', JSON.stringify(into_position));
                location.href = "/gwspxt/departmentPosition";
            },

        },
        mounted() {
            this.getDeptInfo({currentPage: 1});
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil
        }
    });
})