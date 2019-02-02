package top.dustone.kaixin.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageRouteController {

    @GetMapping(value = "/login")
    public String login() {
        return "admin/frame/login";
    }

    @GetMapping(value = "/phoneLogin")
    public String phoneLogin() {
        return "phone/frame/login";
    }

    //前台路由
    @GetMapping(value = "/phone")
    public String phone() {
        return "phone/frame/phoneFrame";
    }

    //后台路由
    @GetMapping(value = "/admin")
    public String adminHome() {
        return "admin/frame/adminFrame";
    }

    @GetMapping(value = "/admin/frame/baseboard")
    public String adminBaseboard() {
        return "admin/frame/baseboard";
    }

    @GetMapping(value = "/admin/pages/driverList")
    public String driverList() {
        return "admin/pages/driverList";
    }

    @GetMapping(value = "/admin/pages/customerList")
    public String customerList() {
        return "admin/pages/customerList";
    }

    @GetMapping(value = "/admin/pages/machineList")
    public String machineList() {
        return "admin/pages/machineList";
    }

    @GetMapping(value = "/admin/pages/machineTypeList")
    public String machineTypeList() {
        return "admin/pages/machineTypeList";
    }

    @GetMapping(value = "/admin/pages/supportList")
    public String supportList() {
        return "admin/pages/supportList";
    }

    @GetMapping(value = "/admin/pages/logErrorList")
    public String logErrorList() {
        return "admin/pages/logErrorList";
    }

    @GetMapping(value = "/admin/pages/logMaintainList")
    public String logMaintainList() {
        return "admin/pages/logMaintainList";
    }

    @GetMapping(value = "/admin/pages/logOilList")
    public String logOilList() {
        return "admin/pages/logOilList";
    }

    @GetMapping(value = "/admin/pages/logTransportList")
    public String logTransportList() {
        return "admin/pages/logTransportList";
    }

    @GetMapping(value = "/admin/pages/logWorkList")
    public String logWorkList() {
        return "admin/pages/logWorkList";
    }

    @GetMapping(value = "/admin/pages/compactList")
    public String compactList() {
        return "admin/pages/compactList";
    }

    @GetMapping(value = "/admin/pages/machineMap")
    public String machineMap() {
        return "admin/pages/machineMap";
    }

    @GetMapping(value = "/admin/dialogs/dialogRegister")
    public String dialogRegister() {
        return "admin/dialogs/dialogRegister";
    }

    @GetMapping(value = "/admin/dialogs/machineChooser")
    public String machineChooser() {
        return "admin/dialogs/machineChooser";
    }

    @GetMapping(value = "/admin/dialogs/supportChooser")
    public String supportChooser() {
        return "admin/dialogs/supportChooser";
    }

    @GetMapping(value = "/admin/dialogs/driverChooser")
    public String driverChooser() {
        return "admin/dialogs/driverChooser";
    }

    @GetMapping(value = "/admin/dialogs/customerChooser")
    public String customerChooser() {
        return "admin/dialogs/customerChooser";
    }

    @GetMapping(value = "/admin/pages/driverInfo")
    public String driverInfo() {
        return "admin/pages/driverInfo";
    }

    @GetMapping(value = "/admin/pages/machineInfo")
    public String machineInfo() {
        return "admin/pages/machineInfo";
    }

    @GetMapping(value = "/admin/pages/machineTypeInfo")
    public String machineTypeInfo() {
        return "admin/pages/machineTypeInfo";
    }

    @GetMapping(value = "/admin/pages/customerInfo")
    public String customerInfo() {
        return "admin/pages/customerInfo";
    }

    @GetMapping(value = "/admin/pages/contactInfo")
    public String contactInfo() {
        return "admin/pages/contactInfo";
    }

    @GetMapping(value = "/admin/pages/supportInfo")
    public String supportInfo() {
        return "admin/pages/supportInfo";
    }

    @GetMapping(value = "/admin/pages/logOilInfo")
    public String logOilInfo() {
        return "admin/pages/logOilInfo";
    }

    @GetMapping(value = "/admin/pages/logErrorInfo")
    public String logErrorInfo() {
        return "admin/pages/logErrorInfo";
    }

    @GetMapping(value = "/admin/pages/logMaintainInfo")
    public String logMaintainInfo() {
        return "admin/pages/logMaintainInfo";
    }

    @GetMapping(value = "/admin/pages/logTransportInfo")
    public String logTransportInfo() {
        return "admin/pages/logTransportInfo";
    }

    @GetMapping(value = "/admin/pages/logWorkInfo")
    public String logWorkInfo() {
        return "admin/pages/logWorkInfo";
    }

    @GetMapping(value = "/admin/pages/compactInfo")
    public String compactInfo() {
        return "admin/pages/compactInfo";
    }

    @GetMapping(value = "/phone/pages/home")
    public String phoneHome() {
        return "phone/pages/home";
    }
}
