$(function() {
	new Vue({
		el: '#compactQueryTable',
		data: {
			trs: [],
			pagination: {},
			requestModel: {
				start: 0,
				example: {
					type:"",
					status: "",
					contact: {},
					customer: {},
					fromTime: "",
					toTime: ""
				}
			},
			pageNow: 0
		},
		mounted: function() {
			compactQueryVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				var ajaxRequestModel = DEEP_COPY(self.requestModel);
				ajaxRequestModel.example = checkEmpty(ajaxRequestModel.example);
				axios.post(PAGE_COMPACT_QUERY, ajaxRequestModel).then(function(response) {
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
					id: "compactInfo" + tr.id,
					eId: "compactInfoAera",
					eNum: tr.id,
					name: '合同_' + tr.id,
					url: ROUTE_COMPACT_INFO,
					target: 'CompactInfo',
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
					id: "compactInfo",
					eId: "compactInfoAera",
					eNum: "ADD",
					name: '新建合同',
					url: ROUTE_COMPACT_INFO,
					target: 'CompactAdd',
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
			date: function(value) {
				return value.substr(0, 10);
			}
		},
	});

	function vueChooseDate(type, value) {
		compactQueryVue.chooseDate(type, value);
	}

	layui.use('laydate', function() {
		var laydate = layui.laydate;

		laydate.render({
			elem: '#compactListSTime',
			type: 'datetime',
			value: new Date(946174560000),
			done: function(date) {
				vueChooseDate(1,Date.parse(date));
			}
		});
		laydate.render({
			elem: '#compactListETime',
			type: 'datetime',
			value: new Date(),
			done: function(date) {
				vueChooseDate(2,Date.parse(date));
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
