//Global parameters
var navData=[];
var navDataTra=[];
var navOpened=[];
var navDataURL = "http://localhost:8080/kaixin/sys_makeDrawer";
var leftDrawer;
var tabBarIns;



$(function() {
	leftDrawer = new mdui.Drawer('#left-drawer');
	tabBarIns = new mdui.Tab('#tabBar');
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
		},
		methods:{
			chooseTab:function(event){
				var tabId=event.target.getAttribute("tabId");
				makeTab(tabId);
			}
		}
	});
	
	mdui.mutation();
});
function makeTab(tabId){
	if(navOpened.indexOf(tabId)==-1){
		var navTab=findTabInfoById(tabId);
		var tabBar='<a href="#tab'+tabId+'-window" id="tab'+tabId+'" class="mdui-ripple mdui-ripple-white">'+navTab.name+
		'<button class="mdui-btn mdui-btn-block mdui-btn-icon mdui-btn-dense mdui-color-theme-accent mdui-ripple"><i class="mdui-icon material-icons">add</i></button></a>';
		var tabWindow='<div id="tab'+tabId+'-window"><iframe url="www.baidu.com"></iframe></div>'
		$("#tabBar").append(tabBar);
		$("#tabWindows").append(tabWindow);
		navOpened.push(tabId);
		//rebuild the bar to refresh
		tabBarIns = new mdui.Tab('#tabBar');
		tabBarIns.show("tab"+tabId);
	}else{
		tabBarIns.show("tab"+tabId);
	}
}
function findTabInfoById(tabId){
	for(var i=0,len=navDataTra.length;i<len;i++){
		if(navDataTra[i].id==tabId){
			return navDataTra[i];
		}
	}
}
function transformNavData(){
	for(var i=0,len=navData.length;i<len;i++){
		
		var each=navData[i].sysDrawers;
		for(var j=0,len1=each.length;j<len1;j++){
			navDataTra.push(each[j]);
		}
	}
	console.log(navDataTra);
}

