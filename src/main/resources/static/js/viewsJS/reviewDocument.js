$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        docData: '', //所有数据
        showData: '', //显示在页面的数据
        ready: false,
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },
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

    var reviewDocument = new Vue({
        el: "#content",
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
                $.post('http://localhost:8080/gwspxt/getAllDocument', params, function (response) {
                    reviewDocument.docData = response.list;
                    reviewDocument.page.currentPage = response.currentPage;
                    reviewDocument.page.totalPage = response.totalPage;
                    reviewDocument.page.allRow = response.allRow;
                    reviewDocument.page.currentPage = response.currentPage;
                    reviewDocument.page.hasPreviousPage = response.hasPreviousPage;
                    reviewDocument.page.hasNextPage = response.hasNextPage;
                    reviewDocument.ready = true;
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
            }
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
            'page-util': pageUtil,
        }
    });
})