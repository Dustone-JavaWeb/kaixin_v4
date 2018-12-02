var tableInfo = [];
var tableVue;
var infoVue;
var infoWindow;
var baseURL = "http://localhost:8080/kaixin";
var ajaxQueryURL = baseURL + "/machines_query";
var ajaxUpdateURL = baseURL + "/drivers_update";
var exchange;

$(function() {
	new Vue({
		el: '#queryTable',
		data: {
			trs: [],
			pagination: {},
			requestModel: {
				start: 0,
				example: {
					machineType:{},
					status: ""
				}
			},
			pageNow:0
		},
		mounted: function() {
			tableVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				self.requestModel.example = checkEmpty(self.requestModel.example);
				axios.post(ajaxQueryURL, self.requestModel).then(function(response) {
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
			showInfo: function(id) {
				showEditWindow(id);
			},
			addEntity: function(){
				showAddWindow(0);
			},
			pageSelected: function(num) {
				var self = this;
				console.log(self.pageNow);
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
	new Vue({
		el: '#detailDialog',
		data: {
			entity: {},
			inputDisabled: false,
			editButtonText: '编辑',
			giveUpButtonText: '放弃',
			giveUpButtonDisplay: 'none',
			title: "机器信息",
			requestModel: {
				start: 0,
				example: {
					id: 0
				}
			}
		},
		mounted: function() {
			infoVue = this;
		},
		methods: {
			query: function(dId) {
				var self = this;
				self.inputDisabled = true;
				self.requestModel.example = {};
				self.requestModel.example.id = dId;
				self.requestModel.start = 0;
				console.log(self.requestModel.example);
				axios.post(ajaxQueryURL, self.requestModel).then(function(response) {
					self.entity = response.data.content[0];
					mdui.mutation();
				});
			},
			prepareToAdd:function(parent){
				this.entity={};
				this.inputDisabled=false;
				this.editButtonText = '保存';
				this.giveUpButtonDisplay = 'inline';
			},
			switchMode: function(option) {
				var self = this;
				if (self.inputDisabled) {
					self.inputDisabled = false;
					self.editButtonText = '保存';
					self.giveUpButtonDisplay = 'inline';
				} else {
					self.inputDisabled = true;
					self.editButtonText = '编辑';
					self.giveUpButtonDisplay = 'none';
				}
				if (option == 0) {
// 					axios.post(ajaxQueryURL, self.requestModel).then(function(response) {
// 						self.entity = response.data.content[0];
// 					});
					infoWindow.close();
				} else { 
					if (self.inputDisabled) {
						self.requestModel.example = self.entity;
						axios.post(ajaxUpdateURL, self.requestModel).then(function(response) {
							self.entity = response.data.content[0];
							tableQuery(0, tableVue);
						});
					}else{
						//infoWindow.close();
					}
				}
				mdui.mutation();
			}
		}
	});
});

function showEditWindow(dId) {
	infoWindow = new mdui.Dialog("#editWindow");
	infoVue.query(dId);
	infoWindow.open();
}
function showAddWindow(parent){
	infoWindow = new mdui.Dialog("#editWindow");
	infoVue.prepareToAdd(parent);
	infoWindow.open();
}

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
