package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.service.view.GlobalStatusService;
import top.dustone.kaixin.util.BaseboardData;
import top.dustone.kaixin.util.CommonResponseModel;
import top.dustone.kaixin.util.RequestModel;

@CrossOrigin
@RestController
public class GlobalStatusController {
    @Autowired
    GlobalStatusService globalStatusService;
    @PostMapping("/admin_baseboard_data")
    public CommonResponseModel<BaseboardData> makeAdminBaseboardData(@RequestBody RequestModel<BaseboardData> requestModel){
        CommonResponseModel<BaseboardData> result=new CommonResponseModel<BaseboardData>();
        result.setT(globalStatusService.makeBaseboardData());
        result.setCode("200");
        return result;
    }
}
