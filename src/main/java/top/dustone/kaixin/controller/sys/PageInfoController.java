package top.dustone.kaixin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dustone.uams.pojo.User;
import top.dustone.uams.service.rmi.UserAuthorityService;
import top.dustone.uams.util.SimpleMenuInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PageInfoController {
//    @Autowired
//    PageInfoService pageInfoService;
    @Autowired
    UserAuthorityService userAuthorityService;
    @GetMapping("/admin_sys_makeDrawer")
    public List<SimpleMenuInfo> makeDrawerList(HttpSession session){
        User user=(User)session.getAttribute("User");
        return userAuthorityService.getMenuTreeByRoleId(user.getRoleId());
    }
}
