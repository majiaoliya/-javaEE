package com.icis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo4")
public class Demo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.printf(":%s\n", request.getQueryString());
        System.out.printf("虚拟目录:%s\n", request.getContextPath());
//        System.out.printf("访问路径:%s\n", request.getContextPath());
        System.out.printf("uri : %s\n", request.getRequestURI());
        System.out.printf("url : %s\n", request.getRequestURL());
        System.out.printf(" ip : %s\n", request.getRemoteAddr());
        System.out.printf("referer : %s\n", request.getHeader("referer"));
        Enumeration<String> head = request.getHeaderNames();
        System.out.printf("headers:\n");
        while(head.hasMoreElements()) {
            String key = head.nextElement();
            System.out.printf("[%s %s]\n", key, request.getHeader(key));
        }
        System.out.printf("parameterMap:\n");
        Map<String, String[]> mp = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = mp.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.printf("key  :%s\n", entry.getKey());
            String[] value = entry.getValue();
            for(int i=0; i<value.length; i++) {
                System.out.printf("%s:%s\n", i==0 ? "value" : "     ", value[i]);
            }
        }
    }
}
