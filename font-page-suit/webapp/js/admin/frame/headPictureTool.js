var headPirctureVue;
$(function() {
	new Vue({
		el: '#headPictureTool',
		data: {
			entity: {},
			file: "",
			picName: "",
			targetUrl: ""
		},
		mounted: function() {
			var self = this
			headPirctureVue = this;
		},
		methods: {
			prepareInfo: function(targetEntity, pName, tUrl) {
				var self = this;
				self.entity = targetEntity;
				self.picName = pName;
				self.targetUrl = tUrl;
			},
			upLoadFile: function(event) {
				var self = this;
				this.file = event.target.files[0];

				var formData = new FormData();
				formData.append("fileUpload", this.file);
				formData.append("pId", this.entity.resource.id);
				formData.append("originName", this.file.name);
				formData.append("saveDir", this.saveDir);
				axios.post(RESOURCE_UPLOAD, formData).then(function(response) {
					mdui.snackbar({
						message: response.data.code + response.data.msg,
						timeout: 2000,
						position: "right-bottom",
					});
					if (response.data.t != null) {
						if (self.entity.resource.resources == null) {
							self.entity.resource.resources = [];
						}
						self.entity.resource.resources.push(response.data.t);
					}
					mdui.mutation();
				});
				mdui.mutation();
			},
		}
	});
});

function chooseHeadPircture(targetEntity, picName, targetUrl) {
	headPirctureVue.prepareInfo(targetEntity, picName, targetUrl);
	$("#headPictureButton").click();
}
