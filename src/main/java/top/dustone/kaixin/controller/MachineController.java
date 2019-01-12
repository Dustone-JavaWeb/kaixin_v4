package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        Page4Navigator<Machine> page=machineService.listByExample(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        return page;
    }
    @PostMapping("/machines_update")
    public Page4Navigator<Machine> update(@RequestBody RequestModel<Machine> requestModel){
        Page4Navigator<Machine> page=machineService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
    @GetMapping("/machine_info")
    public Machine findById(@RequestParam(value = "id") int id){
        return machineService.findById(id);
    }
}
