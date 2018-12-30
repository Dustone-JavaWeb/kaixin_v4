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
						self.entity.resource.resources.push(response.data.t);
					}
					mdui.mutation();
				});
				mdui.mutation();
			},
			editFileName: function(resource) {
				var self = this;
				fileManageDialog.close();
				mdui.prompt("文件别名", "修改别名", function(value) {
					resource.name = value;
					console.log(resource);
					axios.post(RESOURCE_UPDATE, resource).then(function(response) {
						mdui.snackbar({
							message: response.data.code + response.data.msg,
							timeout: 2000,
							position: "right-bottom",
						});
					});
					fileManageDialog.open();
				}, function() {
					fileManageDialog.open();
				}, {
					confirmText: "确认",
					cancelText: "取消",
					defaultValue: resource.name
				});
			},
			deleteFile: function(resource) {
				var self = this;
				fileManageDialog.close();
				mdui.confirm("删除文件", "被删除的文件不可恢复", function(value) {
					console.log(resource);
					axios.post(RESOURCE_DELETE, resource).then(function(response) {
						mdui.snackbar({
							message: response.data.code + response.data.msg,
							timeout: 2000,
							position: "right-bottom",
						});
						var index = self.entity.resource.resources.indexOf(resource);
						if (index > -1) {
							self.entity.resource.resources.splice(index, 1);
						}
					});
					fileManageDialog.open();
				}, function() {
					fileManageDialog.open();
				}, {
					confirmText: "确认",
					cancelText: "取消"
				});
			}
		},
		filters: {
			date: function(value) {
				if (value != null) {
					return value.substr(0, 10);
				} else {
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
