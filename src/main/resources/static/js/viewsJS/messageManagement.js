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
            getInfo(params) {
                var that = this;
                $.post('/gwspxt/getAllMessage', params, function (response) {
                    data.allMessageData = response.list;
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
                $.post('/gwspxt/isRead', {MobjectId: id}, function (response) {
                    if (response.msg == "updateSuccess") {
                        that.getInfo({currentPage: 1})
                    } else if (response.msg == "updateFailed") {
                    }
                }, 'json')
            },
            allAreRead() {
                let that = this;
                $.post('/gwspxt/allAreRead', {}, function (response) {
                    that.getInfo({currentPage: 1});
                }, 'json')
            },
            replaceMessageType(type) {
                switch (type) {
                    case 1:
                        return "<span class=\"label label-default\">批阅申请</span>";
                    case 2:
                        return "<span class=\"label label-warning\">申请通过</span>";
                    case 3:
                        return "<span class=\"label label-info\">公文审核</span>";
                    case 4:
                        return "<span class=\"label label-primary\">审核通过</span>";
                    case 5:
                        return "<span class=\"label label-danger\">通知</span>";
                }
            }
        },
        mounted() {
            this.getInfo({currentPage: 1});
        },
        components: {
            'asideComponent': Layout,
        }
    });
});
