/*在vue.js后  和   主页面用的js前   引入*/

/* 左侧的导航栏
* 1：用户信息                         **必传**
* 2：页面名字，用来决定li的选中状态   **必传**
* <aside-component :user="user"
                   :name="name">
  </aside-component>
* */
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


/*分页信息组件
*1：绑定父方法，查询方法，可以直接查询，判断已经在组件内部完成  **必填**
*2：当前页码  **必传**
* <page-util @change="change"
             :page="page">
  </page-util>
* */
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
                        <li class="footer"><a href="messageManagement">查看所有信息</a></li>
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
                            <a href="javascript:;" @click="showPop"><i class="fa fa-ban fa-fw pull-right"></i> 登出</a>
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
        },
        showPop() {
            spop({
                template: '<a href="loginout">确认退出当前账号</a>',
                style: 'error',
                autoclose: 5000
            });
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

/*头部控件
* 必须先声明头部控件，再引用。。
* 上，就是对头部控件的声明
* */
var userInfo = new Vue({
    el: "#header",
    components: {
        'header-component': Header
    }
})


/* 表头的查询方法封装
* 使用方法
* 1: 所要查询的数据，即下拉所包含的数据按照格式填入
*    如 docConfidential: { name: "文档密级",items: [{key: "1", value: "绝密"}]}
* 2: 所查询的数据类型名称，依照此查询对应数据
* 3: 绑定父方法，通过对 2数据的判断可以更简便的使用，只需要一个父方法即可
* <search-util :query="docType"
               :search-name="'documentType'"
               @search="search">
 </search-util>
*
* */
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


/* 操作确认框组件
* 使用说明
* 1:按钮的样式  ---------------   默认为 btn btn-default btn-sm
* 2:icon图标的样式  -----------   默认为 fa fa-trash-o fa-fw
* 3:弹出框的标题   -----------    默认为 确定执行操作吗?
* 4:按钮的文字  ----------------  默认为 操作
* 5:所获得的对象所在数组的下标  - **必传**
* 6:绑定的父方法  ------------    **必填**
*<sure-util :btn-class="''"
            :i-class="''"
            :title="''"
            :btn-text="''"
            :index="index"
            @action="">
*</sure-util>
* */
var sureUtil = Vue.extend({
    template: `<button @click="initialize"
            :ref="index"
			:class="btnClass"
			data-toggle="popover"
			:title="title"
			data-trigger="focus"
			data-html="true"
			data-placement="auto right"
			data-content='<div id="popover" class="btn-toolbar" role="toolbar">
                               <div class="btn-group" role="group"><button @click="sure" type="button" class="btn btn-danger">确认</button></div>
                               <div class="btn-group" role="group"><button type="button" class="btn btn-default">取消</button></div>
                          </div>'><i :class="iClass"></i> {{btnText}}</button>`,
    methods: {
        initialize() {
            let that = this;
            setTimeout(function () {
                new Vue({
                    el: "#popover",
                    methods: {
                        sure() {
                            that.perform();
                        },
                    },
                }, 200)
            })
        },
        perform() {
            this.$emit('action', this.index);
        }
    },
    mounted() {
        $(this.$refs[this.index]).popover();
        /*$('[data-toggle="popover"]').popover();*/
    },
    props: {
        btnClass: {default: "btn btn-default btn-sm"},
        iClass: {default: 'fa fa-trash-o fa-fw'},
        title: {default: '确定执行操作吗?'},
        btnText: {default: '操作'},
        index: {required: true}
    }
})