package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.MachineBrand;
import top.dustone.kaixin.entity.MachineType;
import top.dustone.kaixin.service.MachineBrandService;
import top.dustone.kaixin.service.MachineTypeService;
import top.dustone.kaixin.util.CommonResponseModel;
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
    @PostMapping("/admin_machineType_query")
    public Page4Navigator<MachineType> list(@RequestBody RequestModel<MachineType> requestModel){
        Page4Navigator<MachineType> page=machineTypeService.listByExample(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        return page;
    }
    @PostMapping("/admin_machineBrand_query")
    public Page4Navigator<MachineBrand> listBrand(@RequestBody RequestModel<MachineBrand> requestModel){
        Page4Navigator<MachineBrand> page=machineBrandService.list();
        return page;
    }
    @PostMapping("/admin_machineType_update")
    public CommonResponseModel<MachineType> update(@RequestBody RequestModel<MachineType> requestModel){
        return machineTypeService.update(requestModel.getExample());
    }
    @GetMapping("/admin_machineType_list")
    public List<MachineType> listTypes(){
        return machineTypeService.listAll();
    }
}
