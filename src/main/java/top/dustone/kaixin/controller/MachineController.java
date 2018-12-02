package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.Machine;
import top.dustone.kaixin.service.MachineService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class MachineController {
    @Autowired
    MachineService machineService;
    @PostMapping("/machines_query")
    public Page4Navigator<Machine> list(@RequestBody RequestModel<Machine> requestModel){
        System.out.println(requestModel);
        Page4Navigator<Machine> page=machineService.listByExample(requestModel.getExample(),requestModel.getStart(),5,5);
        page.setExample(requestModel);
        return page;
    }
}
