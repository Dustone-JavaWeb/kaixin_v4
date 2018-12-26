$(function() {
	new Vue({
		el: '#machineTypeQueryList',
		data: {
			parentCards: [],
			childCards: [],
			requestModel: {
				example: {}
			},
			brandSelected: null
		},
		mounted: function() {
			machineTypeVue = this;
			this.list();
		},
		methods: {
			list: function() {
				var self = this;
				self.requestModel.example = checkEmpty(self.requestModel.example);
				axios.post(PAGE_MACHINE_BRAND_QUERY,{}).then(function(response) {
					self.parentCards = response.data.content;
					mdui.mutation();
				});
				axios.post(PAGE_MACHINE_TYPE_QUERY, self.requestModel).then(function(response) {
					self.childCards = response.data.content;
					mdui.mutation();
				});
			},
			showInfo: function(id) {
				showEditWindow(id);
			},
			addEntity: function() {
				showAddWindow(0);
			},
			chooseBrand: function(brand) {
				this.brandSelected=brand;
			},
			cardSelected: function(id) {
				var self = this;

				if (self.brandSelected == null) {
					return {
						'mdui-hidden': false
					}
				} else if (id == self.brandSelected.id) {
					return {
						'mdui-hidden': false
					}
				} else {
					return {
						'mdui-hidden': true
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
