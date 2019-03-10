package top.dustone.kaixin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value="/admin_user_info")
    public CommonResponseModel<SysUser> getUserInfo(HttpSession session){
        CommonResponseModel<SysUser> result=new CommonResponseModel<SysUser>();
        SysUser sysUser=(SysUser) session.getAttribute("sysUser");
        if(null==sysUser){
            result.setMsg("Session信息异常！ 请重新登陆");
            result.setCode("404");
            return result;
        }
        else{
            SysUser newUser=new SysUser();
            newUser.setAvatar(sysUser.getAvatar());
            newUser.setId(sysUser.getId());
            newUser.setUsername(sysUser.getUsername());
            newUser.setNickName(sysUser.getNickName());
            result.setT(newUser);
            result.setCode("200");
            return result;
        }
    }
    @GetMapping(value="/admin_user_logout")
    public CommonResponseModel<SysUser> logOut(HttpSession session){
        CommonResponseModel<SysUser> result=new CommonResponseModel<SysUser>();
        session.removeAttribute("sysUser");
        result.setCode("200");
        result.setMsg("注销成功！ 即将返回登陆界面！");
        //System.out.println(result);
        return result;
    }
}
