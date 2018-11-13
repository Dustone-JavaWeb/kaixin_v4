var tableInfo = [];
var tableVue;
var ajaxQueryURL = "http://localhost:8080/kaixin/drivers";
$(function() {
	tableVue = new Vue({
		el: '#queryTable',
		data: {
			trs: [],
			pagination: {},
		},
		mounted: function() {
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				axios.get(ajaxQueryURL + "?start=" + start).then(function(response) {
					self.pagination = response.data;
					console.log(self.pagination);
					self.trs = response.data.content;
					mdui.mutation();
				});
			},
			jump: function(page) {
				var self = this;
				jump(page, self); //定义在adminHeader.html 中
			},
			jumpByNumber: function(start) {
				var self = this;
				jumpByNumber(start, self);
			},
		},
		filters: {
			status: function(value) {
				if (value == 0) {
					return '空闲';
				} else if (value == 1) {
					return '工作';
				} else if (value == 2) {
					return '休假';
				} else {
					return '离职';
				}
			},
			type: function(value) {
				if (value == 0) {
					return "正式";
				} else {
					return "临时";
				}
			},
			date: function(value) {
				return value.substr(0, 10);
			}
		},
	})
});

function jump(page, vue) {
	if ('first' == page && !vue.pagination.first)
		vue.list(0);

	else if ('pre' == page && vue.pagination.hasPrevious)
		vue.list(vue.pagination.number - 1);

	else if ('next' == page && vue.pagination.hasNext)
		vue.list(vue.pagination.number + 1);

	else if ('last' == page && !vue.pagination.last)
		vue.list(vue.pagination.totalPages - 1);
}
//分页跳转函数，跳转到指定页
function jumpByNumber(start, vue) {
	if (start != vue.pagination.number)
		vue.list(start);
}
