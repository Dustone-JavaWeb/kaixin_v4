var BASE_URL="http://localhost:8080/kaixin";
var BASE_ROUTE_URL="http://127.0.0.1:8848/font-page-suit/templates/";
var BASE_ROUTE_LAST_TOKEN=".html";

//前端页面路由
var FRAME_DIALOG_REGISTER=BASE_ROUTE_URL+"admin/dialogs/dialogRegister"+BASE_ROUTE_LAST_TOKEN;
var DIALOG_MACHINE_CHOOSER=BASE_ROUTE_URL+"admin/dialogs/machineChooser"+BASE_ROUTE_LAST_TOKEN;
var DIALOG_SUPPORT_CHOOSER=BASE_ROUTE_URL+"admin/dialogs/supportChooser"+BASE_ROUTE_LAST_TOKEN;
var DIALOG_DRIVER_CHOOSER=BASE_ROUTE_URL+"admin/dialogs/driverChooser"+BASE_ROUTE_LAST_TOKEN;
var DIALOG_CUSTOMER_CHOOSER=BASE_ROUTE_URL+"admin/dialogs/customerChooser"+BASE_ROUTE_LAST_TOKEN;

var ROUTE_DRIVER_INFO=BASE_ROUTE_URL+"admin/pages/driverInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_MACHINE_INFO=BASE_ROUTE_URL+"admin/pages/machineInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_SUPPORT_INFO=BASE_ROUTE_URL+"admin/pages/supportInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_CUSTOMER_INFO=BASE_ROUTE_URL+"admin/pages/customerInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_LOG_OIL_INFO=BASE_ROUTE_URL+"admin/pages/logOilInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_LOG_ERROR_INFO=BASE_ROUTE_URL+"admin/pages/logErrorInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_LOG_MAINTAIN_INFO=BASE_ROUTE_URL+"admin/pages/logMaintainInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_LOG_TRANSPORT_INFO=BASE_ROUTE_URL+"admin/pages/logTransportInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_LOG_WORK_INFO=BASE_ROUTE_URL+"admin/pages/logWorkInfo"+BASE_ROUTE_LAST_TOKEN;
var ROUTE_COMPACT_INFO=BASE_ROUTE_URL+"admin/pages/compactInfo"+BASE_ROUTE_LAST_TOKEN;

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

var PAGE_LOG_OIL_QUERY=BASE_URL+"/logOil_query";
var PAGE_LOG_OIL_UPDATE=BASE_URL+"/logOil_update";
var PAGE_LOG_TRANSPORT_QUERY=BASE_URL+"/logTransport_query";
var PAGE_LOG_TRANSPORT_UPDATE=BASE_URL+"/logTransport_update";
var PAGE_LOG_WORK_QUERY=BASE_URL+"/logWork_query";
var PAGE_LOG_WORK_UPDATE=BASE_URL+"/logWork_update";
var PAGE_LOG_MAINTAIN_QUERY=BASE_URL+"/logMaintain_query";
var PAGE_LOG_MAINTAIN_UPDATE=BASE_URL+"/logMaintain_update";
var PAGE_LOG_ERROR_QUERY=BASE_URL+"/logError_query";
var PAGE_LOG_ERROR_UPDATE=BASE_URL+"/logError_update";

var PAGE_MACHINE_MAP_VIEW_QUERY=BASE_URL+"/machine_map_view_query";
var PAGE_MACHINE_STATUS_VIEW_QUERY=BASE_URL+"/machine_status_view_query";

var PAGE_COMPACT_QUERY=BASE_URL+"/compact_query";
var PAGE_COMPACT_UPDATE=BASE_URL+"/compact_update";
var PAGE_MACHINE_INFO=BASE_URL+"/machine_info";
var PAGE_DRIVER_INFO=BASE_URL+"/driver_info";
var PAGE_SUPPORT_INFO=BASE_URL+"/support_info";
var PAGE_COMPACT_INFO=BASE_URL+"/compact_info";


var RESOURCE_UPLOAD=BASE_URL+"/resource_upload";
var RESOURCE_UPDATE=BASE_URL+"/resource_update";
var RESOURCE_DELETE=BASE_URL+"/resource_delete";
var RESOURCE_UPLOAD_HEAD_PIC=BASE_URL+"/resource_head_pic_upload";