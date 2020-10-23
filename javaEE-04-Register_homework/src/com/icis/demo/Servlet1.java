package com.icis.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用request域对象  在多个servlet之间传递数据
 * * 方法：
 1. void setAttribute(String name,Object obj):存储数据
 2. Object getAttitude(String name):通过键获取值
 3. void removeAttribute(String name):通过键移除键值对
 */
@WebServlet("/demo1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet1......");
        //设置数据
        request.setAttribute("msg","我是Servlet1设置的数据.");
        //获得servletContext对象
        ServletContext servletContext = request.getServletContext();

        System.out.println("--------------------------------------------------------------");
        //请求转发到Servlet2
        request.getRequestDispatcher("/demo2").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
