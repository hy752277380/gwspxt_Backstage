/*在vue.js后  和   主页面用的js前   引入*/

/* 左侧的导航栏 */
var Layout = Vue.extend({
    template: `<aside style="height: 712px;" class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
    <div class="user-panel">
        <div class="pull-left image">
        <!--用户头像图片位置----------->  <!--暂时不改动，使用固定头像-->
        <img src="http://www.hywebsite.cn/static/gif/rabbit.gif" class="img-circle" alt="User Image"/>
        </div>
        <div class="pull-left info">
        <!--用户名字位置--------------->
        <p v-cloak>{{user.guser.userName}}</p><a href=""><i class="fa fa-circle text-success"></i> Online</a>
    </div>
    </div>
    <!-- search form -->
    <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="Search..."/>
        <span class="input-group-btn">
        <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
    </span>
    </div>
    </form>
    <!-- /.search form -->
    <ul class="sidebar-menu">
    <li :class="name=='index'?'active':''"><a href="index.html"><i class="fa fa-home fa-fw"></i><span>首页</span></a></li>
    
    <li :class="name=='approvalApplication'?'active':''"><a href="approvalApplication.html"><i class="fa fa-pencil-square-o fa-fw"></i><span>批阅申请</span></a></li>
    
    <li :class="name=='addDocument'?'active':''"><a href="addDocument.html"><i class="fa fa-clipboard fa-fw"></i><span>添加文档</span></a></li>
    
    <li :class="name=='reviewDocument'?'active':''"><a href="reviewDocument.html"> <i class="fa fa-th-list fa-fw"></i><span>文档查看</span></a></li>
    
    <li :class="name=='documentManage'?'active':''"><a href="documentManage.html"><i class="fa fa-book fa-fw"></i><span>文档管理</span></a></li>
    
    <li :class="name=='checkDocument'?'active':''"><a href="checkDocument.html"><i class="fa fa-book fa-fw"></i><span>审核文档</span></a></li>
    
    <li :class="name=='information'?'active':''"><a href="information.html"><i class="fa fa-meh-o fa-fw"></i><span>个人信息</span></a></li>

    <li :class="name=='journal'?'active':''"><a href="journal.html"><i class="fa fa-location-arrow fa-fw"></i><span>查看日志</span></a></li>
    
    <li :class="name=='departmentMemberManage'?'active':''"><a href="departmentMemberManage.html"><i class="fa fa-male fa-fw"></i><span>部门成员管理</span></a></li>
    
    <li :class="name=='accountManagement'?'active':''"><a href="accountManagement.html"><i class="fa fa-user fa-fw"></i><span>账号管理</span></a></li>
    
    <li :class="name=='departmentManagement'?'active':''"><a href="departmentManagement.html"><i class="fa fa-gavel fa-fw"></i><span>部门管理</span></a></li>
    
    <li :class="name=='processManagement'?'active':''"><a href="processManagement.html"><i class="fa fa-sitemap fa-fw"></i><span>流程管理</span></a></li>
    
    </ul>
    </section>
    <!-- /.sidebar -->
    </aside>`,
    props: ['user', 'name'],
})


/*分页信息*/
var pageUtil = Vue.extend({
    template: `<ul style="color: #606266" class="pagination">
		<li :class="pageUtil.hasPreviousPage?'':'disabled'"><a href="javascript:" @click="pre()"><span aria-hidden="true">&laquo;</span></a></li>
		<li v-for="index in pageUtil.totalPage" :class="{'active' : pageUtil.currentPage == index}">
			<a @click="btnclick(index)" href="javascript:">{{index}}</a>
		</li>
		<li :class="pageUtil.hasNextPage?'':'disabled'"><a href="javascript:" @click="next()"><span aria-hidden="true">&raquo;</span></a></li>
		<li><input v-model="pageUtil.currentPage" style="width: 34px; height: 34px; display: inline;" type="text" class="form-control" :placeholder="pageUtil.currentPage"></li>
		<li><strong>共{{page.allRow}}条记录,当前显示{{page.pageSize}}/页</strong></li>
		</ul>`,
    data() {
        return {
            pageUtil: this.page,
        }
    },
    methods: {
        btnclick(index) {
            this.$data.pageUtil.currentPage = index;
        },
        next() {
            if (this.$data.pageUtil.hasNextPage) {
                this.$data.pageUtil.currentPage++;
            } else {
                spop({template: "没有下一页了", style: "info", autoclose: 2000});
            }
        },
        pre() {
            if (this.$data.pageUtil.hasPreviousPage) {
                this.$data.pageUtil.currentPage--;
            } else {
                spop({template: "没有上一页了", style: "info", autoclose: 2000});
            }
        },
    },
    watch: {
        'pageUtil.currentPage': function (newVal, oldVal) {
            var reg = /^[1-9]\d*$|^0$/;
            if (newVal == oldVal) {
                /* 第一次为子组件的触发监听，第二次为父组件改变值时的触发监听，为多余的一次监听，不做处理 */
            }
            else if (reg.test(newVal) == true) {
                if (newVal <= this.$data.pageUtil.totalPage && newVal > 0) {
                    this.$data.pageUtil.currentPage = newVal;
                    this.$emit('change', newVal);
                } else {
                    this.$data.pageUtil.currentPage = oldVal;
                    spop({template: "超出总页面数", style: "info", autoclose: 2000});
                }
            } else if (newVal < 1) {
                this.$data.pageUtil.currentPage = oldVal;
                spop({template: "请输入大于0的数字", style: "info", autoclose: 2000});
            } else {
                this.$data.pageUtil.currentPage = oldVal;
                spop({template: "请输入正确的数字", style: "info", autoclose: 2000});
            }

        }
    },
    props: ['page'],
})


var Header = Vue.extend({
    template: `<!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope"></i>
                        <span class="label label-success">{{message.number}}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">{{message.number}}条未读消息</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li>
                                    <!-- start message -->
                                    <a v-for="(msg,index) in message.msgContent" href="">
                                        <div class="pull-left">
                                            <img src="http://www.hywebsite.cn/static/gif/rabbit.gif" class="img-circle" alt="User Image"/>
                                        </div>
                                        <h4>{{msg.title}}</h4>
                                        <p>{{msg.content}}</p>
                                        <small class="pull-right"><i class="fa fa-clock-o"></i> 5 mins</small>
                                    </a>
                                </li>
                                <!-- end message -->
                            </ul>
                        </li>
                        <li class="footer"><a href="">查看所有信息</a></li>
                    </ul>
                </li>
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user"></i>
                        <span>{{user.guser.userName}}<i class="caret"></i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                        <li class="dropdown-header text-center">帐号</li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:;">
                                <i class="fa fa-user fa-fw pull-right"></i> 帐号
                            </a>
                            <a data-toggle="modal" href="#modal-user-settings">
                                <i class="fa fa-cog fa-fw pull-right"></i> 设置
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href=""><i class="fa fa-ban fa-fw pull-right"></i> 登出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>`,
    data() {
        return {
            user: JSON.parse(sessionStorage.getItem("loginUser")),
            message: {
                number: 0,
                msgContent: [],
            },
        }
    },
    methods: {
        repleace(num) {
            switch (num) {
                case 1 :
                    return "批阅申请";
                case 2 :
                    return "申请通过";
                case 3 :
                    return "公文审核";
                case 4 :
                    return "审核通过";
                case 5 :
                    return "通知";
            }
        },
        getMessage(that) {
            $.post('/gwspxt/getAllMessage', {}, function (response) {
                that.message.number = response.length;
                let newMsgContent = [];
                for (let item in response) {
                    let newMsg = {
                        title: that.repleace(response[item].message.messageType),
                        content: response[item].message.messageContent,
                    }
                    newMsgContent.push(newMsg);
                }
                that.message.msgContent = newMsgContent;
            }, 'json');
        }
    },
    mounted() {
        const that = this;
        this.getMessage(that);
        setInterval(function () {
            that.getMessage(that);
        }, 10000)
    },
})

/*头部控件*/
var userInfo = new Vue({
    el: "#header",
    components: {
        'header-component': Header
    }
})


/*   表头的查询方法封装 */
var searchUtil = Vue.extend({
    template: `<span role="presentation" class="dropdown">
                   <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">{{query.name}}<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                       <li v-for="item in query.items"><a href="javascript:;" @click="search(item.key)" :key="item.key">{{item.value}}</a></li>
                   </ul>
                   </span>`,
    methods: {
        search(key) {
            this.$emit('search', {key: key, searchName: this.searchName});
        },
    },
    props: ['query', 'searchName'],
});