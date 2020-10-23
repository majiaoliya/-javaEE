package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.User;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
//            UserDao dao = new UserDao();
            boolean ok = service.findUserByUser(user);
            if(ok) {
                RequestDispatcher dp = request.getRequestDispatcher("/getUserList");
                request.getSession().setAttribute("user", user);
                dp.forward(request, response);

//                System.out.println("ok " + ok);
//                response.sendRedirect(request.getContextPath() + "/pages/list.jsp");

            } else {
                RequestDispatcher dp = request.getRequestDispatcher("/pages/login.jsp");
                request.getSession().setAttribute("error_msg", "用户名或密码错误");
                System.out.println("ok " + ok);
                dp.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String vcode = (String) request.getSession().getAttribute("vcode");
        String check_code = request.getParameter("verifycode");
        if(check_code == null) check_code = "";
        if(vcode == null) vcode = "!@#$%";

        HttpSession session = request.getSession();
        if(vcode.equalsIgnoreCase(check_code.toString())) {
            session.setAttribute("error_msg", "相同");
//            session.invalidate(); //设置session失效
            session.removeAttribute("vcode");
        } else {
            session.setAttribute("error_msg", "验证码错误");
            RequestDispatcher dp = request.getRequestDispatcher("/pages/login.jsp");
            dp.forward(request, response);
        }

        System.out.printf("user : %s check_code:%s\n", user.toString(), check_code);

    }
}
