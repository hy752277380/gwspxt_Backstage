$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'journal',
        logData: [], //所有数据
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
            /*label($event) {
                $('.event_year>li').removeClass('current');
                $($event.target).parent('li').addClass('current');
                var year = $($event.target).attr('for');
                $('#' + year).parent().prevAll('div').slideUp(800);
                $('#' + year).parent().slideDown(800).nextAll('div').slideDown(800);
            },*/
            getInfo(params) {
                $.post('/gwspxt/getAllLog', params, function (response) {
                    data.logData = response;
                    data.ready = true;
                }, 'json');
            }
        },
        mounted() {
            this.getInfo({year: 2018});
            $('[data-toggle="popover"]').popover({html: true});
        },
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });
})