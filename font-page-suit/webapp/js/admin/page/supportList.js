$(function() {
	new Vue({
		el: '#supportQueryTable',
		data: {
			trs: [],
			pagination: {},
			requestModel: {
				start: 0,
				example: {
					type: "",
					status: ""
				}
			},
			pageNow:0
		},
		mounted: function() {
			supportQueryVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				self.requestModel.example = checkEmpty(self.requestModel.example);
				axios.post(PAGE_SUPPORT_QUERY, self.requestModel).then(function(response) {
					self.pagination = response.data;
					self.trs = response.data.content;
					self.pageNow = response.data.number+1;
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
			query: function() {
				var self = this;
				tableQuery(0, self);
			},
			showInfo: function(tr) {
				var tabMsg={
					id:"supportInfo"+tr.id,
					eId:"supportInfoAera",
					eNum:tr.id,
					name:'后勤信息_'+tr.name,
					url:ROUTE_SUPPORT_INFO,
					target:'SupportInfo',
					initData:{
						entity:tr
					}
				}
				makeInfoTab(tabMsg);
			},
			addEntity: function(){
				showAddWindow(0);
			},
			pageSelected: function(num) {
				var self = this;
				if (num == self.pageNow) {
					return {
						'mdui-color-theme-accent': true
					}
				} else {
					return {
						'mdui-color-theme-accent': false
					}
				}
			}
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
	});
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

function tableQuery(start, vue) {
	vue.list(start);
}

function checkEmpty(jsonObject) {
	var result = {};
	for (var key in jsonObject) {
		if (jsonObject[key] == "") {
			continue;
		}
		result[key] = jsonObject[key];
	}
	return result;
}
