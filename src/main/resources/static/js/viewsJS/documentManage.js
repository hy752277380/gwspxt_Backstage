$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'documentManage',
        docData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        index: '',
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
        docType: {
            name: "文档类型",
            items: [
                {key: "命令", value: "命令"},
                {key: "批复", value: "批复"},
                {key: "意见", value: "意见"},
                {key: "函", value: "函"},
                {key: "会议纪要", value: "会议纪要"},
                {key: "决定", value: "决定"},
                {key: "公告", value: "公告"},
                {key: "通告", value: "通告"},
                {key: "通知", value: "通知"},
                {key: "通报", value: "通报"},
                {key: "议案", value: "议案"},
                {key: "报告", value: "报告"},
                {key: "请示", value: "请示"},
            ],
        },
        docConfidential: {
            name: "文档密级",
            items: [
                {key: "1", value: "绝密"},
                {key: "2", value: "机密"},
                {key: "3", value: "秘密"},
                {key: "4", value: "普通"},
            ],
        },
        documentState: {
            name: "文档状态",
            items: [
                {key: "0", value: "退回"},
                {key: "1", value: "草稿"},
                {key: "2", value: "待审核"},
                {key: "3", value: "审核中"},
                {key: "4", value: "已审核"},
                {key: "5", value: "已归档"},

            ],
        },
        docDepartment: 0,
    }

    /*分页信息*/
    var pageUtil = Vue.extend({
        template: `<ul style="color: #606266" class="pagination">
		<li :class="page.hasPreviousPage?'':'disabled'"><a href="javascript:" @click="next('-')"><span aria-hidden="true">&laquo;</span></a></li>
		<li v-for="index in page.totalPage" :class="{'active' : page.currentPage == index}">
			<a @click="btnclick(index)" href="javascript:">{{index}}</a>
		</li>
		<li :class="page.hasNextPage?'':'disabled'"><a href="javascript:" @click="next('+')"><span aria-hidden="true">&raquo;</span></a></li>
		<li><input v-model="topage" style="width: 34px; height: 34px; display: inline;" type="text" class="form-control" :placeholder="page.currentPage"></li>
		<li><strong>共{{page.allRow}}条记录,当前显示{{page.pageSize}}/页</strong></li>
		</ul>`,
        data() {
            return {
                topage: data.page.currentPage,
            }
        },
        methods: {
            btnclick(index) {
                data.page.currentPage = index;
            },
            next($to) {
                if ($to == "+") {
                    if (data.page.hasNextPage) {
                        data.page.currentPage++;
                    } else {
                        spop({
                            template: "没有下一页了",
                            style: "info",
                            autoclose: 2000
                        })
                    }
                }
                if ($to == "-") {
                    if (data.page.hasPreviousPage) {
                        data.page.currentPage--;
                    } else {
                        spop({
                            template: "没有上一页了",
                            style: "info",
                            autoclose: 2000
                        })
                    }
                }
                /*  更新当前页面显示  */
                this.topage = data.page.currentPage;
            },
        },
        watch: {
            'topage': function (newVal, oldVal) {
                var reg = /^[1-9]\d*$|^0$/;
                if (reg.test(newVal) == true) {
                    if (newVal <= data.page.totalPage && newVal > 0) {
                        this.topage = newVal;
                        data.page.currentPage = newVal;
                    } else {
                        this.topage = oldVal;
                        data.page.currentPage = oldVal;
                        spop({
                            template: "超出总页面数",
                            style: "info",
                            autoclose: 2000
                        })
                    }
                } else {
                    this.topage = oldVal;
                }
            }
        },
        props: ['page'],
    })

    var searchUtil = Vue.extend({
        template: `<span role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">{{query.name}}<span class="caret"></span></a>
                     <ul class="dropdown-menu">
                         <li v-for="item in query.items"><a href="javascript:;" :key="item.key">{{item.value}}</a></li>
                     </ul>
                   </span>`,
        props: ['query'],
    });

    var documentManage = new Vue({
        el: "#main",
        data: data,
        methods: {
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
            getInfo(params) {
                $.post('/gwspxt/getDocumentByState', params, function (response) {
                    documentManage.docData = response.list;
                    documentManage.page.currentPage = response.currentPage;
                    documentManage.page.totalPage = response.totalPage;
                    documentManage.page.allRow = response.allRow;
                    documentManage.page.currentPage = response.currentPage;
                    documentManage.page.hasPreviousPage = response.hasPreviousPage;
                    documentManage.page.hasNextPage = response.hasNextPage;
                    documentManage.ready = true;
                }, 'json');
            },
            replaceConfidential(documentConfidential) {
                switch (documentConfidential) {
                    case 1:
                        return "<span class=\"label label-danger\">绝密</span>";
                    case 2:
                        return "<span class=\"label label-warning\">机密</span>";
                    case 3:
                        return "<span class=\"label label-info\">秘密</span>";
                    case 4:
                        return "<span class=\"label label-primary\">普通</span>";
                }
            },
            replaceState(documentState) {
                switch (documentState) {
                    case 0:
                        return "<span class=\"label label-danger\">退回</span>";
                    case 1:
                        return "<span class=\"label label-default\">草稿</span>";
                    case 2:
                        return "<span class=\"label label-warning\">待审核</span>";
                    case 3:
                        return "<span class=\"label label-primary\">审核中</span>";
                    case 4:
                        return "<span class=\"label label-info\">已审核</span>";
                    case 5:
                        return "<span class=\"label label-success\">已归档</span>";
                }
            },
            editDocument(index) {
                var lhs_edit = {
                    "action": "edit",
                    "doc_id": this.docData[index].document.documentId
                }
                sessionStorage.setItem('lhs_edit', JSON.stringify(lhs_edit));
                location.href = "/gwspxt/reviewDetailDocument";
            },
            checkDocument(index) {
                var lhs_check = {
                    action: "check",
                    doc_id: this.docData[index].document.documentId
                }
                sessionStorage.setItem('lhs_docId', JSON.stringify(lhs_check));
                window.location.href = "/gwspxt/reviewDetailDocument";
            },


        },

        mounted() {
            this.getInfo({
                currentPage: 1
            });
        },
        watch: {
            'page.currentPage': function (newVal, oldVal) {
                if (newVal > this.page.totalPage) {
                    this.page.totalPage = oldVal;
                    spop({
                        template: "没有这个页面",
                        style: "info",
                        autoclose: 2000
                    })
                } else if (newVal < 1) {
                    spop({
                        template: "输入页面有误",
                        style: "info",
                        autoclose: 2000
                    })
                } else if (!(/(^[0-9]*[1-9][0-9]*$)/.test(newVal))) {
                    spop({
                        template: "输入正确的数字",
                        style: "info",
                        autoclose: 2000
                    })
                } else {
                    this.getInfo({
                        currentPage: this.page.currentPage
                    });
                }
            },
        },
        components: {
            'asideComponent': Layout,
            'page-util': pageUtil,
            'search-util': searchUtil,
        }
    });
})