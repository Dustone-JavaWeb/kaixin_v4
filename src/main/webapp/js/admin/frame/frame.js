//Global parameters
var leftDrawer;
var tabBarIns;
var appCore;

$(function() {
	leftDrawer = new mdui.Drawer('#left-drawer');
	configAxiosInterceptors();
	loadDialogs();
	changeTabContentHeight();

	layui.use('element', function() {
		var element = layui.element;
		//监听tab页面关闭
		element.on('tabDelete(model)', function(data) {
			//console.log(this.parentNode); //当前Tab标题所在的原始DOM元素
			var deleteTabId = this.parentNode.getAttribute("lay-id");
			if (deleteTabId != 0) {
				NAV_OPENED.splice(NAV_OPENED.indexOf(deleteTabId), 1);
			}
		});
	});
	//hide or show drawer
	$("#drawButton").click(function() {
		leftDrawer.toggle();
	});
	$("#homeButton").click(function () {
        makeBaseboardTab();
    });
	$("#logoutButton").click(function () {

		axios.get(FRAME_USER_LOGOUT).then(function (response) {
            console.log(response);
			if(response.data.code=="200"){
                window.location.href = 'login';
			}
        });
    });
	//JSON to get navInfo
	$.getJSON(FRAME_NAV_DATA_URL, function(data) {
		NAV_DATA = data;
		transformNavData();
	})
	//左侧导航栏
	new Vue({
		el: '#left-drawer-list',
		data: {
			drawerItems: []
		},
		mounted: function() {
			var self = this
			axios.get(FRAME_NAV_DATA_URL).then(function(response) {
				self.drawerItems = response.data;
                //console.log(JSON.stringify(self.drawerItems));
			});
		},
		methods: {
			chooseTab: function(event) {
				var tabId = event.target.getAttribute("tabId");
				makeTab(tabId);
			}
		}
	});
	//用户登陆信息
	new Vue({
        el: '#frame-tool-bar',
        data: {
            sysUser:{}
        },
        mounted: function() {
            var self = this
            self.initInfo();
        },
        methods: {
			initInfo:function () {
                var self = this
                axios.get(FRAME_LOGINUSER_INFO).then(function(response) {
                    self.sysUser = response.data.t;
                });
            }
        }
	});
	makeBaseboardTab();
	mdui.mutation();
});

function makeBaseboardTab(){
    layui.use('element', function() {
        var element = layui.element;
        var tabId="baseboard";
        if (NAV_OPENED.indexOf(tabId) == -1) {
            $.get(ROUTE_BASEBOARD_PAGE, function(data) {
                element.tabAdd('model', {
                    title: '控制台',
                    content: data,
                    id: tabId
                });
                NAV_OPENED.push(tabId);
                element.tabChange('model', tabId);
            });
        } else {
            element.tabChange('model', tabId);
        }
        mdui.mutation();
    });
}


//处理导航栏开启的TAB
function makeTab(tabId) {
	layui.use('element', function() {
		var element = layui.element;
		if (NAV_OPENED.indexOf(tabId) == -1) {
			var navTab = findTabInfoById(tabId);
			$.get(BASE_ROUTE_URL+navTab.url, function(data) {
				element.tabAdd('model', {
					title: navTab.name,
					content: data,
					id: tabId
				});
				NAV_OPENED.push(tabId);
				element.tabChange('model', tabId);
			});
		} else {
			element.tabChange('model', tabId);
		}
		mdui.mutation();
	});
}
//处理详细信息引起的TAB
function makeInfoTab(tabMsg) {
	layui.use('element', function() {
		var element = layui.element;
		if (NAV_OPENED.indexOf(tabMsg.id) == -1) {
			$.get(tabMsg.url, function(data) {
				//处理导航逻辑
				var reg = "/" + tabMsg.eId + "/g";
				data = data.replace(eval(reg), tabMsg.eId + tabMsg.eNum);
				element.tabAdd('model', {
					title: tabMsg.name,
					content: data,
					id: tabMsg.id
				});
				var invokeTarget = eval("init" + tabMsg.target);
				invokeTarget(tabMsg);

				NAV_OPENED.push(tabMsg.id);
				element.tabChange('model', tabMsg.id);
			});
		} else {
			element.tabChange('model', tabMsg.id);
		}
		mdui.mutation();
	});
}


function findTabInfoById(tabId) {
	for (var i = 0, len = NAV_DATA_TRA.length; i < len; i++) {
		if (NAV_DATA_TRA[i].id == tabId) {
			return NAV_DATA_TRA[i];
		}
	}
}

function transformNavData() {
	for (var i = 0, len = NAV_DATA.length; i < len; i++) {

		var each = NAV_DATA[i].childs;
		if(each!=null){
            for (var j = 0, len1 = each.length; j < len1; j++) {
                NAV_DATA_TRA.push(each[j]);
            }
		}
	}
}

function changeTabContentHeight() {
	var content = document.getElementById("adminTabContent");
	var content2;
	content.style.height = (document.documentElement.clientHeight - 99) + "px";
	if (content2=document.getElementById("mapContainer")) {
		content2.style.height = (document.documentElement.clientHeight - 99) + "px";
	}
}
function configAxiosInterceptors(){
    axios.interceptors.response.use(function (response) {
    	var responseMsg=response.request.responseText;
        if(response.headers["content-length"]==253){
        	if(response.headers["content-type"]=="text/html;charset=utf-8") {
                mdui.snackbar({
                    message: "验证信息失效！ 三秒后返回登陆界面！",
                    timeout: 3000,
                    position: "right-bottom",
                });

                function skipToLogin() {
                    window.location.href = 'login';
                }

                var t = window.setTimeout(skipToLogin, 3000);
            }
		}
		else if(-1!=responseMsg.indexOf('授权失败！')){
            mdui.snackbar({
                message:response.data,
                buttonText: '关闭',
                timeout: 5000,
                position: "right-bottom",
            });
		}
        return response;
    }, function (error) {
        // Do something with response error
        return Promise.reject(error)
    })
}

function loadDialogs() {
	$("#adminFrameDialogs").load(FRAME_DIALOG_REGISTER);
}
window.onresize = function() {
	changeTabContentHeight();
}
