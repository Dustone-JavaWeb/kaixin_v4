package top.dustone.kaixin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import top.dustone.kaixin.entity.sys.SysUser;
import top.dustone.kaixin.service.sys.SysUserService;
import top.dustone.kaixin.util.CommonResponseModel;

import javax.servlet.http.HttpSession;

@RestController
public class AuthorizeController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping(value = "/login")
    public CommonResponseModel<SysUser> login(@RequestBody SysUser sysUser, HttpSession session){
        CommonResponseModel<SysUser> result=new CommonResponseModel<SysUser>();
        String username =  sysUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        sysUser =sysUserService.get(username,sysUser.getPassword());
        if(null==sysUser){
            result.setMsg("用户名或密码错误！");
            result.setCode("404");
            return result;
        }
        else{
            result.setMsg("登陆成功");
            result.setCode("200");
            session.setAttribute("sysUser",sysUser);
            return result;
        }
    }
}
