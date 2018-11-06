package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.service.DriverService;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;
    @GetMapping("/drivers")
    public List<Driver> list(){
        return driverService.list();
    }
}
