package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.kaixin.entity.SysDrawer;
import top.dustone.kaixin.service.PageInfoService;

import java.util.List;

@RestController
public class PageInfoController {
    @Autowired
    PageInfoService pageInfoService;
    @GetMapping("/sys_makeDrawer")
    public List<SysDrawer> makeDrawerList(){
        return pageInfoService.list();
    }
}