package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.User;
import com.icis.utils.LoginUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        LoginUtil.accept(request, response);


        HttpSession session = request.getSession();
        String root = request.getContextPath();

//        Map<String, String[]> mp = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = mp.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            System.out.printf("%s : ", entry.getKey());
//            String[] value = entry.getValue();
//            for (String s : value) {
//                System.out.printf("[%s] ", s);
//            }
//            System.out.println("]");
//        }
        User user = service.findUserById(request.getParameter("id"));

        user.setGender(request.getParameter("sex"));
        user.setAge(request.getParameter("age"));
        user.setAddress(request.getParameter("address"));
        user.setEmail(request.getParameter("email"));
        user.setQq(request.getParameter("qq"));
//        new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(""))
//        user.setBirthday(request.getParameter("qq"));
        int ret = service.updateUserByUser(user);

        response.sendRedirect(request.getContextPath() + "/getUserList");
    }
}
