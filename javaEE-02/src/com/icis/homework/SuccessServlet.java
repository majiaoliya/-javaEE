package com.icis.homework;

import com.icis.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login_ok")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getAttribute("user");
        List<User> list = (List<User>) request.getAttribute("list");
//        if(list.isEmpty()) {
//            out.printf("<h1>欢迎回来，%s!!</h1>", list.get(0).getUsername());
//        }
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.printf("list:%s", list==null ? "fuck null" : list.toString());
        out.printf("<h1>welcome back, %s!!</h1>", list.get(0).getUsername());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
