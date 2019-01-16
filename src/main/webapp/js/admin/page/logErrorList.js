$(function() {
	new Vue({
		el: '#logErrorQueryTable',
		data: {
			trs: [],
			pagination: {},
			requestModel: {
				start: 0,
				example: {
					type:"",
					logMode: "",
					support: {},
					machine: {},
					driver: {},
					fromTime: "",
					toTime: ""
				}
			},
			pageNow: 0
		},
		mounted: function() {
			logErrorQueryVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				var ajaxRequestModel = DEEP_COPY(self.requestModel);
				ajaxRequestModel.example = checkEmpty(ajaxRequestModel.example);
				axios.post(PAGE_LOG_ERROR_QUERY, ajaxRequestModel).then(function(response) {
					self.pagination = response.data;
					self.trs = response.data.content;
					self.pageNow = response.data.number + 1;
					mdui.mutation();
				});
			},
			jump: function(page) {
				var self = this;
				jump(page, self);
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
				var tabMsg = {
					id: "logErrorInfo" + tr.id,
					eId: "logErrorInfoAera",
					eNum: tr.id,
					name: '异常日志_' + tr.id,
					url: ROUTE_LOG_ERROR_INFO,
					target: 'LogErrorInfo',
					initData: {
						entity: tr
					}
				}
				makeInfoTab(tabMsg);
			},
			showChildInfo:function(tr,type){
				var tabMsg;
				if(type=="driver"){
					tabMsg = {
						id: "driverInfo" + tr.id,
						eId: "driverInfoAera",
						eNum: tr.id,
						name: '机手信息_' + tr.id,
						url: ROUTE_DRIVER_INFO,
						target: 'DriverInfo',
						initData: {
							entity: tr
						}
					}
				}else if(type=="support"){
					tabMsg = {
						id: "supportInfo" + tr.id,
						eId: "supportInfoAera",
						eNum: tr.id,
						name: '后勤信息_' + tr.id,
						url: ROUTE_SUPPORT_INFO,
						target: 'SupportInfo',
						initData: {
							entity: tr
						}
					};
				}else if(type=="machine"){
					tabMsg = {
						id: "machineInfo" + tr.id,
						eId: "machineInfoAera",
						eNum: tr.id,
						name: '机器信息_' + tr.id,
						url: ROUTE_MACHINE_INFO,
						target: 'MachineInfo',
						initData: {
							entity: tr
						}
					};
				}
				makeInfoTab(tabMsg);
			},
			addEntity: function() {
				var tabMsg = {
					id: "logErrorInfo",
					eId: "logErrorInfoAera",
					eNum: "ADD",
					name: '新建异常日志',
					url: ROUTE_LOG_ERROR_INFO,
					target: 'LogErrorAdd',
					initData: {}
				}
				makeInfoTab(tabMsg);
			},
			chooseDate: function(type, value) {
				var self = this;
				if (type == 1) {
					self.requestModel.example.fromTime = value;
				} else {
					self.requestModel.example.toTime = value;
				}
				console.log(self.requestModel);
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

	function vueChooseDate(type, value) {
		logErrorQueryVue.chooseDate(type, value);
	}

	layui.use('laydate', function() {
		var laydate = layui.laydate;

		laydate.render({
			elem: '#logErrorListSTime',
			type: 'datetime',
			value: new Date(946174560000),
			done: function(date) {
				vueChooseDate(1, Date.parse(date));
			}
		});
		laydate.render({
			elem: '#logErrorListETime',
			type: 'datetime',
			value: new Date(),
			done: function(date) {
				vueChooseDate(2, Date.parse(date));
			}
		});
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
