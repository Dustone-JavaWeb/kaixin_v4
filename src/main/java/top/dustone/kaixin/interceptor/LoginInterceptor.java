package top.dustone.kaixin.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.dustone.kaixin.entity.sys.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        String contextPath=session.getServletContext().getContextPath();

        String[] requireLogins=new String[]{
                "admin"
        };

        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath+"/");
        String page = uri;

        if(begingWith(page, requireLogins)){
            SysUser sysUser = (SysUser) session.getAttribute("user");
            if(sysUser==null) {
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }
    private boolean begingWith(String page, String[] requireLogins) {
        boolean result = false;
        for (String requireLogin : requireLogins) {
            if(StringUtils.startsWith(page, requireLogin)) {
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
