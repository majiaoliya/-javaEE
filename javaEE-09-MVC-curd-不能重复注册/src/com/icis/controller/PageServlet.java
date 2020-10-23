package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.PageBean;
import com.icis.pojo.User;
import com.icis.utils.LoginUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginUtil.accept(request, response);



        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        PageBean<User> pageBean = service.findPageUser(currentPage, pageSize);

        Map<String, String[]> mp = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = mp.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.printf("%s : ", entry.getKey());
            String[] value = entry.getValue();
            for (String s : value) {
                System.out.printf("[%s] ", s);
            }
            System.out.println("");
        }

        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/pages/list.jsp").forward(request, response);
    }
}
