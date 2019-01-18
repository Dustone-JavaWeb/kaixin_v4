package top.dustone.kaixin.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.log.LogError;
import top.dustone.kaixin.service.log.LogErrorService;
import top.dustone.kaixin.util.Page4Navigator;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class LogErrorController {
    @Autowired
    private LogErrorService logErrorService;
    @PostMapping("/admin_logError_query")
    public Page4Navigator<LogError> list(@RequestBody RequestModel<LogError> requestModel){
        Page4Navigator<LogError> page=logErrorService.listByExapmle(requestModel.getExample(),requestModel.getStart(),requestModel.getPageSize(),5);
        page.setExample(requestModel);
        //System.out.println(page);
        return page;
    }
    @PostMapping("/admin_logError_update")
    public Page4Navigator<LogError> update(@RequestBody RequestModel<LogError> requestModel){
        Page4Navigator<LogError> page=logErrorService.update(requestModel.getExample());
        page.setResponseMessage("保存成功！");
        return page;
    }
}
