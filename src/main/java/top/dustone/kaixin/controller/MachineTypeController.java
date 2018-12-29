package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.MachineBrand;
import top.dustone.kaixin.entity.MachineType;
import top.dustone.kaixin.service.MachineBrandService;
import top.dustone.kaixin.service.MachineTypeService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

import java.util.List;

@CrossOrigin
@RestController
public class MachineTypeController {
    @Autowired
    MachineTypeService machineTypeService;
    @Autowired
    MachineBrandService machineBrandService;
    @PostMapping("/machineType_query")
    public Page4Navigator<MachineType> list(@RequestBody RequestModel<MachineType> requestModel){
        Page4Navigator<MachineType> page=machineTypeService.listByExample(requestModel.getExample());
        System.out.println(page);
        return page;
    }
    @PostMapping("/machineBrand_query")
    public Page4Navigator<MachineBrand> listBrand(@RequestBody RequestModel<MachineBrand> requestModel){
        Page4Navigator<MachineBrand> page=machineBrandService.list();
        return page;
    }
    @GetMapping("/machineType_list")
    public List<MachineType> listTypes(){
        return machineTypeService.listAll();
    }
}
