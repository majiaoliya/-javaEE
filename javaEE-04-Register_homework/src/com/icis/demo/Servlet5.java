package com.icis.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 设置相应数据  HttpServletResponse 类对象
 * 1. 格式：HTTP/1.1 200 ok
 2. 设置状态码：setStatus(int sc)
 */
@WebServlet("/demo5")
public class Servlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应数据的格式  建议 浏览器以utf-8进行解码
       /* response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html");*/

        response.setContentType("text/html;charset=UTF-8");
        //System.out.println("demo5.....");
        //相应字符到浏览器
        PrintWriter writer = response.getWriter();

        //写字符数据到浏览器
        writer.write("你好,浏览器,我接收了你的请求.");

    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
