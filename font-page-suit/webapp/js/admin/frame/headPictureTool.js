var headPirctureVue;
$(function() {
	new Vue({
		el: '#headPictureTool',
		data: {
			entity: {},
			file: "",
			picName: "",
			targetUrl: "",
			requestModel: {
				start: 0,
			}
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
			upLoadPicture: function(event) {
				var self = this;
				this.file = event.target.files[0];
				
				var fileType=this.file.name.substring(this.file.name.lastIndexOf(".")+1);
				var formData = new FormData();
				formData.append("picUpload", this.file);
				formData.append("picName", this.picName+fileType);
				axios.post(RESOURCE_UPLOAD_HEAD_PIC, formData).then(function(response) {
					if(response.data.code=="500"){
						mdui.snackbar({
							message: response.data.code + response.data.msg,
							timeout: 2000,
							position: "right-bottom",
						});
					}else{
						//增加随机数让浏览器自动刷新
						self.entity.headPic=response.data.msg;
						self.requestModel.example=self.entity;
						axios.post(self.targetUrl, self.requestModel).then(function(response){
							mdui.snackbar({
								message: "头像保存成功！",
								timeout: 2000,
								position: "right-bottom",
							});
							
						});
						self.entity.headPic=response.data.msg+'?t='+Math.random();
						console.log(self.entity.headPic);
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
