var BASE_URL="http://localhost:8080/kaixin";
var BASE_ROUTE_URL="http://127.0.0.1:8848/font-page-suit/templates/admin";
var BASE_ROUTE_LAST_TOKEN=".html";

//前端页面路由
var ROUTE_DRIVER_INFO=BASE_ROUTE_URL+"/pages/driverInfo"+BASE_ROUTE_LAST_TOKEN;
var ROURE_MACHINE_INFO=BASE_ROUTE_URL+"/pages/machineInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_SUPPORT_INFO=BASE_ROUTE_URL+"/pages/SUPPORTInfo"+BASE_ROUTE_LAST_TOKEN;

//后端API
var FRAME_NAV_DATA_URL=BASE_URL+"/sys_makeDrawer";
var PAGE_DRIVER_QUERY = BASE_URL + "/drivers_query";
var PAGE_DRIVER_UPDATE = BASE_URL + "/drivers_update";
var PAGE_MACHINE_QUERY=BASE_URL+"/machines_query";
var PAGE_MACHINE_UPDATE=BASE_URL+"/machines_update";
var PAGE_SUPPORT_QUERY=BASE_URL+"/support_query";
var PAGE_SUPPORT_UPDATE=BASE_URL+"/support_update";
var PAGE_MACHINE_TYPE_QUERY = BASE_URL + "/machineType_query";
var PAGE_MACHINE_TYPE_LIST = BASE_URL + "/machineType_list";
var PAGE_MACHINE_TYPE_UPDATE = BASE_URL + "/machineType_update";
var PAGE_MACHINE_BRAND_QUERY= BASE_URL+"/machineBrand_query";
var PAGE_CUSTOMER_QUERY=BASE_URL+"/customer_query";
var PAGE_CUSTOMER_UPDATE=BASE_URL+"/customer_update";
var PAGE_CUSTOMER_CONTACT_QUERY=BASE_URL+"/customer_query_by_contact";

var RESOURCE_UPLOAD=BASE_URL+"/resource_upload";