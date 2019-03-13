package top.dustone.kaixin.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.dustone.kaixin.entity.sys.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

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
            SysUser sysUser = (SysUser) session.getAttribute("sysUser");
            if(sysUser==null) {
                //request.getRequestDispatcher("login").forward(request,response);
//                response.sendRedirect("login");
                String responseText="<div style=\"text-align:center;width:100%;height:100%\">\n" +
                        "\t<h1>认证信息失效！ 将在三秒后返回登陆界面</h1>\n" +
                        "</div>\n" +
                        "<script>\n" +
                        "\tfunction skipToLogin(){\n" +
                        "\t\twindow.location.href = 'login';\n" +
                        "\t}\n" +
                        "\tvar t=window.setTimeout(skipToLogin,3000); \n" +
                        "</script>";
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                //String chset = response.getCharacterEncoding();
                out.print(responseText);
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
