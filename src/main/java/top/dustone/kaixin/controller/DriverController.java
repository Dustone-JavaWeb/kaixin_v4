package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.Driver;
import top.dustone.kaixin.service.DriverService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;
@CrossOrigin
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
    public Page4Navigator<Driver> list(@RequestBody RequestModel<Driver> requestModel){
        Page4Navigator<Driver> page=driverService.listByExapmle(requestModel.getExample(),requestModel.getStart(),5,5);
        page.setExample(requestModel);
        return page;
    }
}
