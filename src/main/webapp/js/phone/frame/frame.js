var leftDrawer;
var leftDrawerVue;
var leftDrawerData;
$(function () {
    init();
    changeTabContentHeight();
    initDrawerInfo(FRAME_NAV_DATA_URL);
    initPages();
});

function init(){
    leftDrawer = new mdui.Drawer('#left-drawer');
    $("#drawButton").click(function() {
        leftDrawer.toggle();
    });
}
function initDrawerInfo(initUrl) {
    leftDrawerVue=new Vue({
        el: '#left-drawer-list',
        data: {
            drawerItems: []
        },
        mounted: function() {
            var self = this
            axios.get(initUrl).then(function(response) {
                self.drawerItems = response.data;
                leftDrawerData=response.data;
            });
        },
        methods: {
            chooseTab: function(event) {
                var tabId = event.target.getAttribute("tabId");
                makeTab(tabId);
            }
        }
    });
}
function initPages(){
    $("#frameContainer").load("phone/pages/home");
}

function changeTabContentHeight() {
    var content = document.getElementById("frameContainer");
    content.style.height = (document.documentElement.clientHeight - 56) + "px";
}
window.onresize = function() {
    changeTabContentHeight();
}