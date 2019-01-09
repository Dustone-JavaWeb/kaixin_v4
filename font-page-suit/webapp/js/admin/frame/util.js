function DEEP_COPY(obj){
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
function checkStringEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
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