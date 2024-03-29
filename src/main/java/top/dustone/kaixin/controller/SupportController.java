package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.Support;
import top.dustone.kaixin.service.SupportService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class SupportController {
    @Autowired
    SupportService supportService;
    @PostMapping("/admin_support_query")
    public Page4Navigator<Support> list(@RequestBody RequestModel<Support> requestModel){
        Page4Navigator<Support> page=supportService.listByExapmle(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/admin_support_update")
    public Page4Navigator<Support> update(@RequestBody RequestModel<Support> requestModel){
        Page4Navigator<Support> page=supportService.update(requestModel.getExample());
        return page;
    }
    @GetMapping("/admin_support_info")
    public Support findById(@RequestParam(value = "id") int id){
        return supportService.findById(id);
    }
}
