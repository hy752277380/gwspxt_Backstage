$(function () {
    var data = {
        user: JSON.parse(sessionStorage.getItem("loginUser")),
        lhs_edit:JSON.parse(sessionStorage.getItem('lhs_edit')),
        name: 'reviewDetailDocument',
        docData: '', //所有数据
        /*ready: false,
        page: {
            allRow: 1,
            totalPage: 1,
            currentPage: 1,
            pageSize: 10,
            hasPreviousPage: false,
            hasNextPage: false,
        },*/
    }
    var reviewDetailDocument = new Vue({
        el: "#main",
        data: data,
        components: {
            'asideComponent': Layout,
            //'page-util': pageUtil,
            //'search-util': searchUtil
        }
    });
})

