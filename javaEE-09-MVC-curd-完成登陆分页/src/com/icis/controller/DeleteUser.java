package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
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

        String id = request.getParameter("id");
        if(null == id) return ;
        int ret = service.deleteUserById(id);

        response.sendRedirect(request.getContextPath() + "/getUserList");
    }
}
