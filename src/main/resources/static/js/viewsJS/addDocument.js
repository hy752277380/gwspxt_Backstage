$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        name: 'accountManagement',
        docData: '', //所有数据
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
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });

    $.ajax({
        type: "post",
        url: "/gwspxt/addDocument",
        dataType: "json",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data),
        success: function (data) {
            if (data) {
                var documentId = data.documentId;
                $.ajax({
                    type: "post",
                    url: "/gwspxt/updateDocumentState",
                    dataType: "json",
                    data: JSON.stringify(data),
                    contentType: 'application/json;charset=UTF-8',
                    success: function (data) {
                        $.ajax({
                            type: "post",
                            url: "/gwspxt/messageNextOne",
                            dataType: "json",
                            data: {
                                "documentId": documentId,
                            },
                            contentType: 'application/json;charset=UTF-8',
                            success: function (data) {
                                window.location.href = "/gwspxt/reviewDocument";
                            }
                        });

                    }
                });
            } else {

            }
        }
    });

})