$(function () {
    "use strict";
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'index',
        docData: '', //所有数据
        companyMemberNum:'',
        companyDocumentNum:'',
        departmentDocumentNum:'',
        personalDocumentNum:'',
        ready: false,
        chars: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: []
        },
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
    var charDataBase = {
        label: "1",
        fillColor: "rgba(217,83,79,0.2)",
        strokeColor: "rgba(217,83,79,1)",
        pointColor: "rgba(217,83,79,1)",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "rgba(220,220,220,1)",
        data: []
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getInfo(parmas) {
                $.post('/gwspxt/countUserByMouth', parmas, function (response) {
                    let label = data.chars.labels;
                    let base = charDataBase;
                    for (let key in label) {
                        base.data.push(response[label[key]])
                    }
                    data.chars.datasets.push(base);

                    console.log(data.chars.labels);
                    console.log(data.chars.datasets);
                    new Chart(document.getElementById("linechart").getContext("2d")).Line(data.chars, {
                        responsive: true,
                        maintainAspectRatio: false,
                    });
                }, 'json');
            }
        },
        mounted() {
            this.getInfo({});
        },
        components: {
            'asideComponent': Layout,
        }
    });

});
Chart.defaults.global.responsive = true;

