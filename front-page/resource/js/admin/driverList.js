var tableInfo = [];
var tableVue;
var ajaxQueryURL = "http://localhost:8080/kaixin/drivers"
$(function() {
	tableVue = new Vue({
		el: '#adminTable',
		data: {
			trs: []
		},
		mounted: function() {
			var self = this
			axios.get(ajaxQueryURL).then(function(response) {
				self.trs = response.data;
				console.log(self.trs);
				mdui.mutation();
			});
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
			type:function(value){
				if(value==0){
					return "正式";
				}else{
					return "临时";
				}
			},
			date: function(value) {
				return value.substr(0,10);
			}
		},
	})
});
