package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.Address;
import com.icis.utils.LoginUtil;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add_servlet")
public class Add extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        LoginUtil.accept(request, response);

        List<Address> addressStr = service.getAddressStr();

        System.out.println("-----begin------add_servlet------");
        System.out.println(addressStr);
        System.out.println("-----end------add_servlet------");

        request.setAttribute("address_list", addressStr);
        request.getRequestDispatcher("/pages/add.jsp").forward(request, response);
    }
}
