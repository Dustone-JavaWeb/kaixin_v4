layui.define(['jquery', 'form', 'layer', 'element'], function(exports) {
	var $ = layui.jquery;
	// generate nav bar info
	//Global parameters
	var navData=[];
	var navDataTra=[];
	var navOpened=[];
	var navDataURL = "http://localhost:8080/kaixin/sys_makeDrawer";
	$(function() {
		$.getJSON(navDataURL,function(data){
			navData=data;
			transformNavData();
			new Vue({
				el: '#navItems',
				data: {
					navItems: []
				},
				mounted: function() {
					var self = this
					this.navItems=navData;
				},
				methods:{
					chooseTab:function(event){
						var tabId=event.target.getAttribute("tabId");
						makeTab(tabId);
					}
				}
			});
			console.log($("#navItems").innerHTML);
			var form = layui.form,
				layer = layui.layer,
				element = layui.element;
		})
		
	});
	
	
	function makeTab(tabId){
		
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
	}
	
	
	
	
	exports('kaixin', {});
});
