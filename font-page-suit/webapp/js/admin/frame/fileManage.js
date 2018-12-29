var fileManageDialog;
var fileManageVue;
$(function() {
	fileManageDialog = new mdui.Dialog('#fileManageDialog');
	new Vue({
		el: '#fileManageTable',
		data: {
			entity: {},
			resources: [],
			file: "",
			saveDir: "",
		},
		mounted: function() {
			var self = this
			fileManageVue = this;
			//self.init();
		},
		methods: {
			init: function(initData, dir) {
				var self = this;
				self.saveDir = dir;
				self.entity = initData;
				self.resources = self.entity.resource.resources;
				mdui.mutation();
			},
			upLoadFile: function(event) {
				var self=this;
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
					if(response.data.t!=null){
						self.entity.resource.resources.push(response.data.t);
					}
					mdui.mutation();
				});
				mdui.mutation();
			}
		},
		filters: {
			date: function(value) {
				if(value!=null){
					return value.substr(0, 10);
				}else{
					return "";
				}
			}
		},
	});
	$("#resourceUploadButtonDisplay").click(function() {
		$("#resourceUploadButton").click();
	});
});

function openFileManageDialog(initData, saveDir) {
	fileManageVue.init(initData, saveDir);
	fileManageDialog.open();
	mdui.mutation();
}
