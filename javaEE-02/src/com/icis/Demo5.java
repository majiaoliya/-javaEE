package com.icis;

import com.icis.pojo.MyUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/Demo5")
public class Demo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader reader = request.getReader();
//        String line = null;
//        System.out.println("line:");
//        while((line=reader.readLine()) != null) {
//            System.out.printf(":%s\n", line);
//        }
        request.setCharacterEncoding("utf-8");

//        String username = request.getParameter("username");
//        String pwd = request.getParameter("pwd");
//        System.out.printf("[username=%s]\n[pwd=%s]\n", username, pwd);
        Map<String, String[]> mp = request.getParameterMap();
        MyUser user = new MyUser();
        try {
            BeanUtils.populate(user, mp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
