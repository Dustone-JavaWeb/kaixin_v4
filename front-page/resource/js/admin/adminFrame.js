//Global parameters
var navData = [];
var navDataTra = [];
var navOpened = [];
var navDataURL = "http://localhost:8080/kaixin/sys_makeDrawer";
var leftDrawer;
var tabBarIns;



$(function() {
	leftDrawer = new mdui.Drawer('#left-drawer');
	tabBarIns = new mdui.Tab('#tabBar');
	layui.use('element', function() {
		var element = layui.element;
		//监听tab页面关闭
		element.on('tabDelete(model)', function(data){
			//console.log(this.parentNode); //当前Tab标题所在的原始DOM元素
			var deleteTabId=this.parentNode.getAttribute("lay-id");
			if(deleteTabId!=0){
				navOpened.splice(navOpened.indexOf(deleteTabId),1);
			}
			// console.log(navOpened);
		});
	});

	//hide or show drawer
	$("#drawButton").click(function() {
		leftDrawer.toggle();
	});
	//JSON to get navInfo
	$.getJSON(navDataURL, function(data) {
		navData = data;
		transformNavData();
	})
	//vue
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
		methods: {
			chooseTab: function(event) {
				var tabId = event.target.getAttribute("tabId");
				makeTab(tabId);
			}
		}
	});
	mdui.mutation();
});


function makeTab(tabId) {
	layui.use('element', function() {
		var element = layui.element;
		if (navOpened.indexOf(tabId) == -1) {
			var navTab = findTabInfoById(tabId);
			element.tabAdd('model', {
				title: navTab.name,
				content: '<iframe class="tabFrame layadmin-iframe" src="' + navTab.url + '" width="100%" height="' + (
					document.documentElement.clientHeight-122) + 'px" frameborder="0" scrolling="auto"></iframe>', //支持传入html
				id: tabId
			});
			navOpened.push(tabId);
			element.tabChange('model', tabId);
		} else {
			element.tabChange('model', tabId);
		}
	});
}

function findTabInfoById(tabId) {
	for (var i = 0, len = navDataTra.length; i < len; i++) {
		if (navDataTra[i].id == tabId) {
			return navDataTra[i];
		}
	}
}

function transformNavData() {
	for (var i = 0, len = navData.length; i < len; i++) {

		var each = navData[i].sysDrawers;
		for (var j = 0, len1 = each.length; j < len1; j++) {
			navDataTra.push(each[j]);
		}
	}
	// console.log(navDataTra);
}
