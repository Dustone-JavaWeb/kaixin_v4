var tableInfo = [];
var tableVue;
var infoVue;
var ajaxQueryURL = "http://localhost:8080/kaixin/drivers_query";
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
					type: "",
					status: ""
				}
			}
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
					mdui.mutation();
				});
				// 				$.ajax({
				// 					type: "POST",
				// 					async:true,
				// 					contentType: "application/json",
				// 					url: ajaxQueryURL,
				// 					data: JSON.stringify(self.requestModel),
				// 					success: function(response) {
				// 						console.log(response);
				// 						self.pagination = response;
				// 						self.trs = response.content;
				// 						//mdui.mutation();
				// 					}
				// 				})
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
				console.log(id);
				showEditWindow(id);
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
			giveUpButtonDisplay:'none',
			title: "机手信息",
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
				self.inputDisabled=true;
				self.requestModel.example.id = dId;
				self.requestModel.start = 0;
				self.requestModel.example = self.requestModel.example;
				axios.post(ajaxQueryURL, self.requestModel).then(function(response) {
					self.entity = response.data.content[0];
					mdui.mutation();
				});
			},
			switchMode: function(option) {
				var self = this;
				console.log(self.inputDisabled);
				if (self.inputDisabled) {
					self.inputDisabled=false;
					self.editButtonText='保存';
					self.giveUpButtonDisplay='inline';
				}else{
					self.inputDisabled=true;
					self.editButtonText='编辑';
					self.giveUpButtonDisplay='none';
				}
				if(option==0){
					alert('放弃');
				}else{
					alert('保存');
				}
				mdui.mutation();
			}
		}
	});
});

function showEditWindow(dId) {
	var inst = new mdui.Dialog("#editWindow");
	infoVue.query(dId);
	inst.open();
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
