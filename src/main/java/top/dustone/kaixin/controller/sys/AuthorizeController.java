package top.dustone.kaixin.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import top.dustone.uams.pojo.User;
import top.dustone.uams.service.rmi.UserAuthorityService;
import top.dustone.kaixin.util.CommonResponseModel;

import javax.servlet.http.HttpSession;

@RestController
public class AuthorizeController {
    public static String[] URL_ALL={
            "admin/dialogs/dialogRegister",
            "admin/dialogs/machineChooser",
            "admin/dialogs/supportChooser",
            "admin/dialogs/driverChooser",
            "admin/dialogs/customerChooser",
            "admin/dialogs/compactChooser",
            "admin_resource_upload",
            "admin_resource_update",
            "admin_resource_delete",
            "admin_resource_head_pic_upload",
            "admin/frame/baseboard",
            "admin_sys_makeDrawer",
            "admin_baseboard_data",
            "admin_user_info",
            "admin_user_logout",
            "admin_home"
    };
    @Autowired
    private UserAuthorityService userAuthorityService;
    @PostMapping(value = "/login")
    public CommonResponseModel<User> login(@RequestBody User user, HttpSession session){
        CommonResponseModel<User> result=new CommonResponseModel<User>();
        String accountNumber =  user.getAccountNumber();
        accountNumber = HtmlUtils.htmlEscape(accountNumber);

        user =userAuthorityService.userAuth(user,"铠信");
        //System.out.println(user);
        if("ERROR".equals(user.getSex())){
            result.setMsg(user.getName());
            result.setCode("404");
            return result;
        }
        else{
            for(String str:URL_ALL){
                user.getAuthUrls().add(str);
            }
            result.setMsg("登陆成功");
            result.setCode("200");
            session.setAttribute("User",user);
            return result;
        }
    }
    @GetMapping(value="/admin_user_info")
    public CommonResponseModel<User> getUserInfo(HttpSession session){
        CommonResponseModel<User> result=new CommonResponseModel<User>();
        User user=(User) session.getAttribute("User");
        if(null==user){
            result.setMsg("Session信息异常！ 请重新登陆");
            result.setCode("404");
            return result;
        }
        else{
            result.setT(user);
            result.setCode("200");
            return result;
        }
    }
    @GetMapping(value="/admin_user_logout")
    public CommonResponseModel<User> logOut(HttpSession session){
        CommonResponseModel<User> result=new CommonResponseModel<User>();
        session.removeAttribute("User");
        result.setCode("200");
        result.setMsg("注销成功！ 即将返回登陆界面！");
        //System.out.println(result);
        return result;
    }
}
