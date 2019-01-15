package top.dustone.kaixin.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.log.LogMaintain;
import top.dustone.kaixin.service.log.LogMaintainService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class LogMaintainController {
    @Autowired
    private LogMaintainService logMaintainService;
    @PostMapping("/logMaintain_query")
    public Page4Navigator<LogMaintain> list(@RequestBody RequestModel<LogMaintain> requestModel){
        Page4Navigator<LogMaintain> page=logMaintainService.listByExapmle(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/logMaintain_update")
    public Page4Navigator<LogMaintain> update(@RequestBody RequestModel<LogMaintain> requestModel){
        Page4Navigator<LogMaintain> page=logMaintainService.update(requestModel.getExample());
        return page;
    }

}
