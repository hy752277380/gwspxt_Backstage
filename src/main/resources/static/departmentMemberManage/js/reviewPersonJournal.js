$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'departmentMemberManage',
        logData: [], //所有数据
        reviewPersonId: sessionStorage.getItem("reviewPersonId"),
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

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            label($event) {
                $('.event_year>li').removeClass('current');
                $($event.target).parent('li').addClass('current');
                var year = $($event.target).attr('for');
                $('#' + year).parent().prevAll('div').slideUp(800);
                $('#' + year).parent().slideDown(800).nextAll('div').slideDown(800);
            },
            getInfo(params) {
                $.post('/gwspxt/getAllLog', params, function (response) {
                    data.logData = response;
                    data.ready = true;
                }, 'json');
            },
            format(fmt) {
                var date = new Date(Date.parse(fmt.replace(/-/g, "/")));
                return date.getMonth() + 1;
                /*var o = {
                    "M+": date.getMonth() + 1, //月份
                    "d+": date.getDate(), //日
                    "h+": date.getHours(), //小时
                    "m+": date.getMinutes(), //分
                    "s+": date.getSeconds(), //秒
                    "q+": Math.floor((date.getMonth() + 3) / 3), //季度
                    "S": date.getMilliseconds() //毫秒
                };
                if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
                for (var k in o)
                    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                return fmt;*/
            }
        },
        mounted() {
            this.getInfo({userId: data.reviewPersonId, year: 2018});
        },
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });
})