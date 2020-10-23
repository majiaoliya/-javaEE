package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.User;
import com.icis.utils.LoginUtil;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getUserById")
public class GetUserById extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");
//        if(null == user) {
//            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
//            return ;
//        }
        LoginUtil.accept(request, response);

        String id = request.getParameter("id");
        User userById = service.findUserById(id);
        System.out.printf("param id:%s\nuser: %s\n", id, userById);
        if(userById == null) { return ; /** TODO */ }
        request.setAttribute("update_user", userById);
        RequestDispatcher dp = request.getRequestDispatcher("/pages/update.jsp");
        dp.forward(request, response);
    }
}
