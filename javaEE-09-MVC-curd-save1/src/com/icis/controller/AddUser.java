package com.icis.controller;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> mp = request.getParameterMap();

        {
            Set<Map.Entry<String, String[]>> entries = mp.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                System.out.printf("[%s = ", entry.getKey());
                String[] value = entry.getValue();
                for (String s : value) {
                    System.out.printf("<%s> ", s);
                }
                System.out.println("]");
            }
        }

        User user = new User();
        try {
            BeanUtils.populate(user, mp);
            String birth = request.getParameter("birthday");
            if (null == birth) birth = "2020-9-8";
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
            System.out.println(user);
            user.setGender(user.getSex());
            int ret = service.insertUserByUser(user);
            System.out.printf("inset status : %d\n", ret);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RequestDispatcher dp = request.getRequestDispatcher("/getUserList");
        dp.forward(request, response);
    }
}
