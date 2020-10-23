package com.icis.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //可以通过Response对象向浏览器写数据
       String  username = (String) request.getAttribute("username");
       //设置response的编码  告诉浏览器  以什么样的方式打开文件和以什么样的方式解码
        response.setContentType("text/html;charset=utf-8");
       //向页面写入数据
        response.getWriter().write("<h3>登录成功！"+username+",欢迎您</h3>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
