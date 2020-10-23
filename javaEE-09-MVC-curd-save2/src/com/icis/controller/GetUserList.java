package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getUserList")
public class GetUserList extends HttpServlet {
    UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String root = request.getContextPath();
        if(session.getAttribute("user") == null) {
            session.setAttribute("error_msg", "会话过期，请重新登陆");
//            RequestDispatcher dp = request.getRequestDispatcher("/pages/login.jsp");
//            dp.forward(request, response);
            response.sendRedirect(root + "/pages/login.jsp");
            return ;
        }

        List<User> list = service.getAllUsers();
        for (User user : list) {
            System.out.printf("user : %s\n", user);
        }
        RequestDispatcher dp = request.getRequestDispatcher( "/pages/list.jsp");
        session.setAttribute("all_users", list);
        dp.forward(request, response);
        System.out.println("getUserslist");
    }
}
