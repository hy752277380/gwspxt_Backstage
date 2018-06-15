$(function() {
	var reviewDocument = new Vue({
		el: "#content",
		data: {
			userinfo: '',
			docData: '', //所有数据
			showData: '', //显示在页面的数据
			ready: false,
			page: {
				lenArr: [10, 20, 40], // 每页显示长度
				pageLen: 5, // 分页数
				haveNext: false,
				havePre: false,
			},

		},
		methods: {
			checkAll($event) {
				if($event.target.checked) {
					$('input[check="self"]').each(function() {
						$(this).prop("checked", true);
					});
				} else {
					$('input[check="self"]').each(function() {
						$(this).prop("checked", false);
					});
				}
			},

		},
		mounted() {
			$.post('http://localhost:8080/gwspxt/getAllDocument', '', function(request) {
				reviewDocument.docData = request;
				reviewDocument.ready = true;
			}, 'json');

		},
		watch() {

		},
		components: {
			pageUtil,
		}
	});

	reviewDocument.component("pageUtil", {
		template: `
		<ul class="pagination pagination-sm">
		<li class="disabled"><a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		<li class="active"><a>1<span class="sr-only">(current)</span></a></li>
		<li>
		<a href="">»</a>
		/li></ul>`,
		data() {

		},
		methods: {

		},
		props: [],
	})
})