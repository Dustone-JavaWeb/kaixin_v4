package top.dustone.kaixin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.sys.SysDrawer;
import top.dustone.kaixin.service.sys.PageInfoService;

import java.util.List;

@RestController
public class PageInfoController {
    @Autowired
    PageInfoService pageInfoService;
    @GetMapping("/admin_sys_makeDrawer")
    public List<SysDrawer> makeDrawerList(){
        return pageInfoService.list();
    }
}
