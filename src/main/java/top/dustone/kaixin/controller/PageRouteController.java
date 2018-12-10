package top.dustone.kaixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageRouteController {
    @GetMapping(value = "/admin_home")
    public String adminHome(){
        return "/page/admin/adminFrame";
    }
    @GetMapping(value = "/admin_driver_list")
    public String listDriver(){
        return "/page/admin/driverList";
    }
    @GetMapping(value = "/admin_machine_list")
    public String listMachine(){
        return "/page/admin/machineList";
    }
    @GetMapping(value = "/admin_machine_type_list")
    public String listMachineType(){
        return "/page/admin/machineTypeList";
    }

}
