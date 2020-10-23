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
import java.util.Map;
import java.util.Set;

@WebServlet("/register")
public class UserRegister extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> mp = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = mp.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.printf("%s : ", entry.getKey());
            String[] value = entry.getValue();
            for (String s : value) {
                System.out.printf("[%s] ", s);
            }
            System.out.println();
        }

        HttpSession session = request.getSession();
        Integer ret = service.registerUserByUserMap(mp);
        String msg = "";
        if(ret > 0) {
            msg = "注册成功请登录";
            request.getSession().setAttribute("error_msg", msg);
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        } else {
            msg = "注册失败 用户名重复";
            request.getSession().setAttribute("error_msg", msg);
            request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
        }


    }
}
