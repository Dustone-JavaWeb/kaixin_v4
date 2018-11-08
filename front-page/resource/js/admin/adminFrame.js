$(function(){
	var leftDrawer=new mdui.Drawer('#left-drawer');
	$("#drawButton").click(function(){
		leftDrawer.toggle();
	})
});




// var tabOpened=[];
// var navData={};
// 
// 
// $(function(){
//     $.getJSON('resource/NavInfo.txt',function(data){
//         navData=data;
//         console.log(navData);
//     })
// });
// 
// layui.use('element', function () {
//     var element = layui.element;
//     //监听tab页面开启
//     element.on("nav(navbar)", function (elem) {
//         //console.log(elem.context); //得到当前点击的DOM对象
//         var selectedId=elem.context.getAttribute("page-id");
//         if(selectedId!=null){
//             if(tabOpened.indexOf(selectedId)==-1){
//                 var selectedNav=navData[selectedId];
//                 //console.log(selectedNav);
//                 element.tabAdd('model', {
//                     title: selectedNav.name,
//                     content: '<iframe class="tabFrame layadmin-iframe" src="'+selectedNav.url+'" width="100%" height="'+(document.documentElement.clientHeight-150)+'px" frameborder="0" scrolling="auto"></iframe>', //支持传入html
//                     id: selectedId
//                 });
//                 tabOpened.push(selectedId);
//             }
//             element.tabChange('model', selectedId);
// 
//         }
//     });
//     //监听tab页面关闭
//     element.on('tabDelete(model)', function(data){
//         //console.log(this.parentNode); //当前Tab标题所在的原始DOM元素
//         var deleteTabId=this.parentNode.getAttribute("lay-id");
//         tabOpened.splice(tabOpened.indexOf(deleteTabId),1);
//     });
// });