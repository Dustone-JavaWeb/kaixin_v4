package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.service.DriverService;
import top.dustone.kaixin.util.Page4Navigator;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;
    @GetMapping("/drivers")
    public Page4Navigator<Driver> list(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "9") int size){
        start = start<0?0:start;
        Page4Navigator<Driver> page =driverService.list(start, size, 5);
        return page;
    }
    @PostMapping("/drivers_query")
    public Page4Navigator<Driver> list(Page4Navigator<Driver> query){
        Page4Navigator<Driver> page=driverService.list(1,5,5);
        return null;
    }
}
