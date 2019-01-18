package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dustone.kaixin.entity.Compact;
import top.dustone.kaixin.service.CompactService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class CompactController {
    @Autowired
    CompactService compactService;
    @PostMapping("/admin_compact_query")
    public Page4Navigator<Compact> list(@RequestBody RequestModel<Compact> requestModel){
        System.out.println(requestModel);
        Page4Navigator<Compact> page=compactService.listByExample(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        return page;
    }
    @GetMapping("/admin_compact_info")
    public Compact findById(@RequestParam(value = "id") int id){
        return compactService.findById(id);
    }

    @PostMapping("/admin_compact_update")
    public Page4Navigator<Compact> update(@RequestBody RequestModel<Compact> requestModel){
        Page4Navigator<Compact> page=compactService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
}
