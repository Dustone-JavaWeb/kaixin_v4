$(function() {
	new Vue({
		el: '#driverInfoAera',
		data: {
			title: "",
			entity: {},
			editPanelModel: "none",
			viewPanelModel: "inline",
			inputDisabled: true,
			requestModel: {
				start: 0,
				example: {
					id: 0,
				}
			}
		},
		mounted: function() {
			driverInfoVue = this;
		},
		methods: {
			init: function(tabMsg) {
				var self = this;
				self.entity = tabMsg.initData.entity;
				this.title = '详细信息';
			},
			switchMode: function(mode) {
				var self = this;
				if (mode == 1) {
					self.editPanelModel = "inline";
					self.viewPanelModel = "none";
					self.inputDisabled = false;
				} else if (mode == 2) {
					self.editPanelModel = "none";
					self.viewPanelModel = "inline";
					self.inputDisabled = true;
					
					self.requestModel.example = self.entity;
					axios.post(PAGE_DRIVER_UPDATE, self.requestModel).then(function(response) {
						self.entity = response.data.content[0];
					});
				} else {
					self.editPanelModel = "none";
					self.viewPanelModel = "inline";
					self.inputDisabled = true;
					
					self.requestModel.example = {};
					self.requestModel.example.id = self.entity.id;
					self.requestModel.start = 0;
					axios.post(PAGE_DRIVER_QUERY, self.requestModel).then(function(response) {
						self.entity = response.data.content[0];
					});
				}
				mdui.mutation();
			}
		}
	})
})




function initDriverInfo(tabMsg) {
	driverInfoVue.init(tabMsg);
}
