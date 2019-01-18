var BASE_URL="http://localhost:8080/kaixin";
var BASE_ROUTE_URL="http://localhost:8080/kaixin/";
var BASE_ROUTE_LAST_TOKEN="";

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
var FRAME_NAV_DATA_URL=BASE_URL+"/admin_sys_makeDrawer";
var PAGE_DRIVER_QUERY = BASE_URL + "/admin_drivers_query";
var PAGE_DRIVER_UPDATE = BASE_URL + "/admin_drivers_update";
var PAGE_MACHINE_QUERY=BASE_URL+"/admin_machines_query";
var PAGE_MACHINE_UPDATE=BASE_URL+"/admin_machines_update";
var PAGE_SUPPORT_QUERY=BASE_URL+"/admin_support_query";
var PAGE_SUPPORT_UPDATE=BASE_URL+"/admin_support_update";
var PAGE_MACHINE_TYPE_QUERY = BASE_URL + "/admin_machineType_query";
var PAGE_MACHINE_TYPE_LIST = BASE_URL + "/admin_machineType_list";
var PAGE_MACHINE_TYPE_UPDATE = BASE_URL + "/admin_machineType_update";
var PAGE_MACHINE_BRAND_QUERY= BASE_URL+"/admin_machineBrand_query";
var PAGE_CUSTOMER_QUERY=BASE_URL+"/admin_customer_query";
var PAGE_CUSTOMER_UPDATE=BASE_URL+"/admin_customer_update";
var PAGE_CUSTOMER_CONTACT_QUERY=BASE_URL+"/admin_customer_query_by_contact";

var PAGE_LOG_OIL_QUERY=BASE_URL+"/admin_logOil_query";
var PAGE_LOG_OIL_UPDATE=BASE_URL+"/admin_logOil_update";
var PAGE_LOG_TRANSPORT_QUERY=BASE_URL+"/admin_logTransport_query";
var PAGE_LOG_TRANSPORT_UPDATE=BASE_URL+"/admin_logTransport_update";
var PAGE_LOG_WORK_QUERY=BASE_URL+"/admin_logWork_query";
var PAGE_LOG_WORK_UPDATE=BASE_URL+"/admin_logWork_update";
var PAGE_LOG_MAINTAIN_QUERY=BASE_URL+"/admin_logMaintain_query";
var PAGE_LOG_MAINTAIN_UPDATE=BASE_URL+"/admin_logMaintain_update";
var PAGE_LOG_ERROR_QUERY=BASE_URL+"/admin_logError_query";
var PAGE_LOG_ERROR_UPDATE=BASE_URL+"/admin_logError_update";

var PAGE_MACHINE_MAP_VIEW_QUERY=BASE_URL+"/admin_machine_map_view_query";
var PAGE_MACHINE_STATUS_VIEW_QUERY=BASE_URL+"/admin_machine_status_view_query";

var PAGE_COMPACT_QUERY=BASE_URL+"/admin_compact_query";
var PAGE_COMPACT_UPDATE=BASE_URL+"/admin_compact_update";
var PAGE_MACHINE_INFO=BASE_URL+"/admin_machine_info";
var PAGE_DRIVER_INFO=BASE_URL+"/admin_driver_info";
var PAGE_SUPPORT_INFO=BASE_URL+"/admin_support_info";
var PAGE_COMPACT_INFO=BASE_URL+"/admin_compact_info";


var RESOURCE_UPLOAD=BASE_URL+"/admin_resource_upload";
var RESOURCE_UPDATE=BASE_URL+"/admin_resource_update";
var RESOURCE_DELETE=BASE_URL+"/admin_resource_delete";
var RESOURCE_UPLOAD_HEAD_PIC=BASE_URL+"/admin_resource_head_pic_upload";