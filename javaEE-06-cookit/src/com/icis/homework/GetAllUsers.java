package com.icis.homework;

import com.icis.dao.UserDao;
import com.icis.pojo.User;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getAllUsers")
public class GetAllUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dp = request.getRequestDispatcher("/jsp/showUsers.jsp");
        UserDao dao = new UserDao();
        List<User> list = dao.getAllUsers();
        if(list == null) list = new ArrayList<>();
        request.setAttribute("list", list);
        dp.forward(request, response);
    }
}
