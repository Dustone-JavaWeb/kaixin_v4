//Global parameters
var navData=[];
var navDataTra=[];
var navDataURL = "http://localhost:8080/kaixin/sys_makeDrawer";
var leftDrawer;



$(function() {
	leftDrawer = new mdui.Drawer('#left-drawer');
	$("#drawButton").click(function() {
		leftDrawer.toggle();
	});
	$.getJSON(navDataURL,function(data){
		navData=data;
		transformNavData();
	})
	new Vue({
		el: '#left-drawer-list',
		data: {
			drawerItems: []
		},
		mounted: function() {
			var self = this
			axios.get(navDataURL).then(function(response) {
				self.drawerItems = response.data;
			});
		}
	});
	mdui.mutation();
});

function transformNavData(){
	alert(navData.length);
	for(var i=0,len=navData.length;i<len;i++){
		
		var each=navData[i].sysDrawers;
		navDataTra.push(each);
// 		for(var j=0;len1=each.length;j<len1;j++){
// 			
// 		}
	}
	//console.log(navDataTra);
}

