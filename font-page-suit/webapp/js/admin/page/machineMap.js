$(function() {
	new Vue({
		el: '#mapInfoList',
		data: {
			trs: [],
			requestModel: {
				start: 0,
				pageSize:10000,
				example: {
					status:""
				}
			},
			pageNow: 0
		},
		mounted: function() {
			mapInfoVue = this;
			this.list(0);
		},
		methods: {
			list: function(start) {
				var self = this;
				self.requestModel.start = start;
				var ajaxRequestModel=DEEP_COPY(self.requestModel);
				ajaxRequestModel.example=checkEmpty(ajaxRequestModel.example);
				axios.post(PAGE_MACHINE_QUERY, ajaxRequestModel).then(function(response) {
					self.trs = response.data.content;
					mdui.mutation();
				});
			},
		},
		watch: {
			"requestModel.example.status": function(val) {
				this.list(0);
			}
		}
	});
});



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
function onApiLoaded() {
	changeTabContentHeight();
	var map = new AMap.Map('mapContainer', {
		center: [117.000923, 36.675807],
		resizeEnable: true,
		zoom: 6
	});
	map.plugin(["AMap.ToolBar"], function() {
		map.addControl(new AMap.ToolBar());
	});
}

