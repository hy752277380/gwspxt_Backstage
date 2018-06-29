$(function () {

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        reviewPersonId: sessionStorage.getItem("reviewPersonId"),
        name: 'departmentMemberManage',
        logData: [], //所有数据
        logMonthNumber: [],//画图使用的数组
        ready: false,
        checkYearNum: 2018,
        checkMonthNum: 0,
        inCheckMonthNumAllLogs: [],
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
            getInfo(params) {
                $.post('/gwspxt/getAllLog', params, response => {
                    data.logData = response;
                    data.ready = true;
                    for (let item in response) {
                        data.logMonthNumber.push(response[item].length);
                    }
                    this.renderChart();
                }, 'json');
            },
            checkMonth(index) {
                data.checkMonthNum = index;
                data.inCheckMonthNumAllLogs = data.logData[index];
            },
            checkYear($event) {
                data.checkYearNum = $event.target.value;
                this.getInfo({userId: data.reviewPersonId, year: data.checkYearNum});
            },
            grepInLogs($event) {
                let key = $event.target.value;
                if (key) {
                    let grepResult = $.grep(data.logData[data.checkMonthNum], (log, i) => {
                        if (log.logContent.search(key) != -1 || log.creationTime.search(key) != -1) {
                            return log;
                        }
                    }, false)
                    data.inCheckMonthNumAllLogs = grepResult;
                } else {
                    data.inCheckMonthNumAllLogs = data.logData[data.checkMonthNum];
                }
            },
            renderChart() {
                let that = this;
                var ctx = document.getElementById("journalChart");
                var myChart = new Chart(ctx, {
                    type: 'polarArea',
                    data: {
                        datasets: [
                            {data: data.logMonthNumber, backgroundColor: that.randomColor(),}
                        ],
                        labels: ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一', '十二'],

                    },
                    options: {}
                });
            },
            randomColor() {
                let color = [];
                for (let i = 10; i--;) {
                    color.push('#' + Math.floor(Math.random() * 0xffffff).toString(16));
                }
                return color;
            }
        },
        mounted() {
            this.getInfo({userId: data.reviewPersonId, year: data.checkYearNum});
        },
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });
})