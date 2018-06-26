$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'information',
        allMessageData: [],
    }

    var reviewDocument = new Vue({
        el: "#main",
        data: data,
        methods: {
            getInfo() {
                var that = this;
                $.post('/gwspxt/getAllMessage', {}, function (response) {
                    data.allMessageData = response;
                }, 'json')
            },
            change($event, index) {
                if ($($event.target).prev('div').hasClass("checked")) {
                    /*$($event.target).prev('div').removeClass("checked");
                    $($event.target).parents('li').removeClass("task-done").attr("aria-disabled", "false");*/
                } else {
                    this.isRead(index);
                    $($event.target).prev('div').addClass("checked");
                    $($event.target).parents('li').addClass("task-done").attr("aria-disabled", "true");
                }
            },
            isRead(index) {
                var that = this;
                let id = data.allMessageData[index].mobject.mobjectMessage;
                $.post('/gwspxt/getAllMessage', {MobjectId: id}, function (response) {
                    that.getInfo();
                }, 'json')
            },
            allAreRead() {
                let that = this;
                $.post('/gwspxt/getAllMessage', {}, function (response) {
                    that.getInfo();
                }, 'json')
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
