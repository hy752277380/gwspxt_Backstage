$(function() {

	var data = {
		userinfo: '',
		docData: '', //所有数据
		showData: '', //显示在页面的数据
		ready: false,
		page: {
			totalCount: 10,
			totalPage: 5,
			currentPage: 1,
			haveNext: false,
			havePre: false,
		},
	}

	var pageUtil = Vue.extend({
		template: `<ul class="pagination">
		<li :class="page.havePre?'':'disabled'"><a @click="next('-')"><span aria-hidden="true">&laquo;</span></a></li>
		<li v-for="index in page.totalPage" :class="{'active' : page.currentPage == index}">
			<a @click="btnclick(index)" href="javascript:">{{index}}</a>
		</li>
		<li :class="page.haveNext?'':'disabled'"><a @click="next('+')"><span aria-hidden="true">&raquo;</span></a></li>
		</ul>`,
		methods: {
			btnclick(index) {
				data.page.currentPage = index;
			},
			next($to) {
				if($to == "+") {
					if(data.page.haveNext)
						data.page.currentPage++;
				}

				if($to == "-") {
					if(data.page.havePre)
						data.page.currentPage--;
				}

			},
		},
		props: ['page'],
	})

	var reviewDocument = new Vue({
		el: "#content",
		data: data,
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
			getInfo(params) {
				$.post('http://localhost:8080/gwspxt/getAllDocument', params, function(request) {
					reviewDocument.docData = request;
					reviewDocument.ready = true;
				}, 'json');
			},
		},
		mounted() {
			this.getInfo({
				currentPage: 1
			});
		},
		watch: {
			'page.currentPage': function() {
				this.getInfo({
					page: this.page.currentPage
				});
			},
		},
		components: {
			'page-util': pageUtil,
		}
	});

})