function DEEP_COPY(obj) {
	var result = JSON.parse(JSON.stringify(obj));
	return result;
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

function checkStringEmpty(obj) {
	if (typeof obj == "undefined" || obj == null || obj == "") {
		return true;
	} else {
		return false;
	}
}

function chooseMachineColor(status) {
	switch (status) {
		case '空闲':
			return '#3F51B5';
			break;
		case '工作':
			return '#4CAF50';
			break;
		case '维修':
			return '#FF9800';
			break;
		case '转场':
			return '#9E9E9E';
			break;
		default:
			return 'black';
	}
}

function chooseFileIcon(type) {
	var startToken = "/resource/staticPicResource/";
	switch (type) {
		case 'doc':
			return startToken + "doc.png";
			break;
		case 'docx':
			return startToken + "doc.png";
			break;
		case 'xls':
			return startToken + "xls.png";
			break;
		case 'xlsx':
			return startToken + "xls.png";
			break;
		case 'ppt':
			return startToken + "ppt.png";
			break;
		case 'pptx':
			return startToken + "ppt.png";
			break;
		case 'zip':
			return startToken + "zip.png";
			break;
		case 'rar':
			return startToken + "zip.png";
			break;
		case 'png':
			return startToken + "pic.png";
			break;
		case 'jpg':
			return startToken + "pic.png";
			break;
		case 'jpeg':
			return startToken + "pic.png";
			break;
		case 'gif':
			return startToken + "pic.png";
			break;
		case 'icon':
			return startToken + "pic.png";
			break;
		default:
			return startToken + "file.png";
	}
}
// function globalCheckDisplay(code,mode){
// 	switch (mode) {
// 		case 'doc':
// 			return startToken + "doc.png";
// 			break;
// 		default:
// 			return startToken + "file.png";
// 	}
// }