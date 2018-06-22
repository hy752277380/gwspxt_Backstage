$(function () {
    Chart.defaults.line.spanGaps = true;
    var lineChartData = {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        datasets: [
            /* {
                 label: 'gongsi',
                 backgroundColor: "rgba(217,83,79,0.2)",
                 borderColor: "rgba(217,83,79,1)",//数据曲线颜色
                 pointBackgroundColor: "#fff", //数据点的颜色
                 fill: true,  //是否要显示数据部分阴影面积块  false:不显示
                 data: [1, 1, 3, 4, 6, 1, 7, 1, 1, 1, 1, 1]
             }*/
        ]
    }

    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'index',
        companyMemberNum: 0,
        companyDocumentNum: 0,
        departmentDocumentNum: 0,
        personalDocumentNum: 0,
        companyMemberState: false,
        companyDocumentState: false,
        departmentDocumentState: false,
        personalDocumentState: false,
    }

    /* 红色  217,83,79 */
    /* 紫色  114,102,186 */
    /* 蓝色  35,183,229 */
    /* 绿色  39,194,76 */
    /* 灰色  151,187,205 */

    /*bootstropt颜色
    * 51,122,183 蓝
    * 92,184,92  绿
    * 91,192,222 浅蓝
    * 240,173,78 黄
    * 217,83,79  红
    * */
    const dataBase = {
        companyMember: {
            label: '公司成员',
            backgroundColor: "rgba(217,83,79,0.2)",
            borderColor: "rgba(217,83,79,1)",//数据曲线颜色
            pointBackgroundColor: "#fff", //数据点的颜色
            fill: true,  //是否要显示数据部分阴影面积块  false:不显示
            data: []
        },
        companyDocument: {
            label: '公司文档',
            backgroundColor: "rgba(114,102,186,0.2)",
            borderColor: "rgba(114,102,186,1)",//数据曲线颜色
            pointBackgroundColor: "#fff", //数据点的颜色
            fill: true,  //是否要显示数据部分阴影面积块  false:不显示
            data: []
        },
        departmentDocument: {
            label: '部门文档',
            backgroundColor: "rgba(35,183,229,0.2)",
            borderColor: "rgba(35,183,229,1)",//数据曲线颜色
            pointBackgroundColor: "#fff", //数据点的颜色
            fill: true,  //是否要显示数据部分阴影面积块  false:不显示
            data: []
        },
        personalDocument: {
            label: '个人文档',
            backgroundColor: "rgba(39,194,76,0.2)",
            borderColor: "rgba(39,194,76,1)",//数据曲线颜色
            pointBackgroundColor: "#fff", //数据点的颜色
            fill: true,  //是否要显示数据部分阴影面积块  false:不显示
            data: []
        },
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getInfo() {
                var that = this;
                /*公司人数总数*/
                $.post('/gwspxt/countUserByMouth', {}, function (response) {
                    let label = lineChartData.labels;
                    let num = 0;
                    let sum = 0;
                    for (let key in label) {
                        num = response[label[key]];
                        dataBase.companyMember.data.push(num);
                        sum += num;
                    }
                    data.companyMemberNum = sum;
                    lineChartData.datasets.push(dataBase.companyMember);
                    data.companyMemberState = true;
                    that.renderChart();
                }, 'json');
                /*公司文档总数*/
                $.post('/gwspxt/countDocumentByMouth', {}, function (response) {
                    let label = lineChartData.labels;
                    let num = 0;
                    let sum = 0;
                    for (let key in label) {
                        num = response[label[key]];
                        dataBase.companyDocument.data.push(num);
                        sum += num;
                    }
                    data.companyDocumentNum = sum;
                    lineChartData.datasets.push(dataBase.companyDocument);
                    data.companyDocumentState = true;
                    that.renderChart();
                }, 'json');
                /*部门文档总数*/
                $.post('/gwspxt/countDptDocumentByMouth', {}, function (response) {
                    let label = lineChartData.labels;
                    let num = 0;
                    let sum = 0;
                    for (let key in label) {
                        num = response[label[key]];
                        dataBase.departmentDocument.data.push(num);
                        sum += num;
                    }
                    data.departmentDocumentNum = sum;
                    lineChartData.datasets.push(dataBase.departmentDocument);
                    data.departmentDocumentState = true;
                    that.renderChart();
                }, 'json');
                /*个人文档总数*/
                $.post('/gwspxt/countPersonalDocumentByMouth', {}, function (response) {
                    let label = lineChartData.labels;
                    let num = 0;
                    let sum = 0;
                    for (let key in label) {
                        num = response[label[key]];
                        dataBase.personalDocument.data.push(num);
                        sum += num;
                    }
                    data.personalDocumentNum = sum;
                    lineChartData.datasets.push(dataBase.personalDocument);
                    data.personalDocumentState = true;
                    that.renderChart();
                }, 'json');
            },
            renderChart() {
                if (data.companyMemberState && data.companyDocumentState && data.departmentDocumentState && data.personalDocumentState) {
                    var ctx = document.getElementById("lineChart");
                    var myChart = new Chart(ctx, {
                        type: 'line',
                        data: lineChartData,
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            },
                        }
                    });
                }
            },
        },
        mounted() {
            this.getInfo();
        },
        components: {
            'asideComponent': Layout,
        }
    });
});
