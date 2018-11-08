package top.dustone.kaixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageRouteController {
    @GetMapping(value = "/admin_driver_list")
    public String listDriver(){
        return "listDriver";
    }
    @GetMapping(value = "/admin_home")
    public String adminHome(){
        return "/frame/admin/adminFrame";
    }
}
