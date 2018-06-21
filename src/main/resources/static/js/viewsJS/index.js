$(function () {
    "use strict";
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'index',
        docData: '', //所有数据
        ready: false,
        chars: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: []
        },
    }

    var charDataBase = {
        label: "1",
        fillColor: "rgba(151,187,205,0.2)",
        strokeColor: "rgba(151,187,205,1)",
        pointColor: "rgba(151,187,205,1)",
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

