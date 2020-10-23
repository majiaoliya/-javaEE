package com.icis.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 判断是否登录
 */
@WebFilter("/*")
public class CheckLoginFilter implements Filter {
    public void destroy() { }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        //判断请求路径包含静态资源和验证码的路径都要放行
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/css/") || /*放行css*/
                requestURI.contains("/js/") ||  /*放行js*/
                requestURI.contains("/vcode") || /*放行验证码*/
                requestURI.contains("/login")) {
            chain.doFilter(req, resp);
            return ;
        }
        if(session.getAttribute("user") != null)
            chain.doFilter(req, resp);
        else {
            request.setAttribute("error_msg", "会话过期");
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
