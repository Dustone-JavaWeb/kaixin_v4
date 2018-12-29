function DEEP_COPY(obj){
	var result = JSON.parse(JSON.stringify(obj));
	return result;
}