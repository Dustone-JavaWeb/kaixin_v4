$(function() {
	new Vue({
		el: '#driverQueryTable',
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
			driverQueryVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				var ajaxRequestModel=DEEP_COPY(self.requestModel);
				ajaxRequestModel.example=checkEmpty(ajaxRequestModel.example);
				axios.post(PAGE_DRIVER_QUERY, ajaxRequestModel).then(function(response) {
					console.log(response.data)
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
					id:"driverInfo"+tr.id,
					eId:"driverInfoAera",
					eNum:tr.id,
					name:'机手信息_'+tr.name,
					url:ROUTE_DRIVER_INFO,
					target:'DriverInfo',
					initData:{
						entity:tr
					}
				}
				makeInfoTab(tabMsg);
			},
			addEntity: function(){
				var tabMsg={
					id:"driverInfo",
					eId:"driverInfoAera",
					eNum:"ADD",
					name:'新增机手',
					url:ROUTE_DRIVER_INFO,
					target:'DriverAdd',
					initData:{}
				}
				makeInfoTab(tabMsg);
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
