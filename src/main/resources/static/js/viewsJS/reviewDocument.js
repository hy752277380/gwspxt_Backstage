$(function() {

	var data = {
		userinfo: '',
		docData: '', //所有数据
		showData: '', //显示在页面的数据
		ready: false,
		page: {
			totalCount: 10,
			totalPage: 3,
			pageindex: 1,
			haveNext: false,
			havePre: false,
		},
	}

	var pageUtil = Vue.extend({
		template: `<ul class="pagination">
		<li :class="page.havePre?'':'disabled'"><a @click="next('-')"><span aria-hidden="true">&laquo;</span></a></li>
		<li v-for="index in page.totalPage" :class="{'active' : page.pageindex == index}">
			<a @click="btnclick(index)" href="javascript:">{{index}}</a>
		</li>
		<li :class="page.haveNext?'':'disabled'"><a @click="next('+')"><span aria-hidden="true">&raquo;</span></a></li>
		</ul>`,
		methods: {
			btnclick(index) {
				data.page.pageindex = index;
			},
			next($to) {
				if($to == "+") {
					if(data.page.haveNext)
						data.page.pageindex++;
				}

				if($to == "-") {
					if(data.page.havePre)
						data.page.pageindex--;
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
				page: 1
			});
		},
		watch: {
			'page.pageindex': function() {
				this.getInfo({
					page: this.page.pageindex
				});
			},
		},
		components: {
			'page-util': pageUtil,
		}
	});

})