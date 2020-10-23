package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.utils.LoginUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/deleteSelectUser")
public class DeleteSelectUser extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, String[]> mp = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = mp.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            System.out.printf("%s = ", entry.getKey());
//            String[] value = entry.getValue();
//            for (String s : value) {
//                System.out.printf("[%s] ", s);
//            }
//            System.out.println("");
//        }
        LoginUtil.accept(request, response);


        String[] ids = request.getParameterValues("ids");
        Integer ret = service.deleteUserByIds(ids);
        System.out.printf("delete cnt:%d\n", ret);

//        request.getRequestDispatcher("/getUserList").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/getUserList");
    }
}
