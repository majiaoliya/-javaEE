package com.icis.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginUtil {

    public static boolean accept(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String root = request.getContextPath();
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null) {
            session.setAttribute("error_msg", "会话过期，请重新登陆");
//            RequestDispatcher dp = request.getRequestDispatcher("/pages/login.jsp");
//            dp.forward(request, response);
            response.sendRedirect(root + "/pages/login.jsp");
            return false;
        }
        return true;
    }
}
