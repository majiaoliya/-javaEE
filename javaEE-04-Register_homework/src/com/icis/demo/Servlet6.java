package com.icis.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**

 */
@WebServlet("/demo6")
public class Servlet6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo6...................");
        System.out.println("我没有钱  百度很有钱 你重新回家去找李彦宏吧");
        System.out.println("---------------------------------");
       /* //执行重定向
        response.setStatus(302);
        //设置重定向路径
        response.setHeader("location","https://www.baidu.com");*/
       //虚拟路径应该动态获取
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/demo7");

    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
