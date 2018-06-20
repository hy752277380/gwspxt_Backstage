/*在vue.js后  和   主页面用的js前   引入*/


/* 左侧的导航栏 */
var Aside = Vue.extend({
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
                        <span class="label label-success">2</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">2条未读消息</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li>
                                    <!-- start message -->
                                    <a href="">
                                        <div class="pull-left">
                                            <img src="http://www.hywebsite.cn/static/gif/rabbit.gif" class="img-circle" alt="User Image"/>
                                        </div>
                                        <h4>Support Team</h4>
                                        <p>Why not buy a new awesome theme?</p>
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
            message: '',
        }
    },
    mounted() {
    },
})

/*头部控件*/
var userInfo = new Vue({
    el: "#header",
    components: {
        'header-component': Header
    }
})