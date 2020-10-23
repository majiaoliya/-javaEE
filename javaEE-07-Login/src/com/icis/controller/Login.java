package com.icis.controller;

import com.icis.dao.UserDao;
import com.icis.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
            UserDao dao = new UserDao();
            boolean ok = dao.findUserByUser(user);
            if(ok) {
                RequestDispatcher dp = request.getRequestDispatcher("/ok");
                dp.forward(request, response);
            } else {
                RequestDispatcher dp = request.getRequestDispatcher("/fail");
                dp.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String vcode = (String) request.getSession().getAttribute("vcode");
        String check_code = request.getParameter("verifycode");
//        for(int i=0; i<check_code.length(); i++) {
//            char ch = check_code.charAt(i);
//            if(ch>='a' && ch<='z') check_code.setCharAt(i, (char)(ch-'a'+'A'));
//        }

        HttpSession session = request.getSession();
        if(vcode.equalsIgnoreCase(check_code.toString())) {
            session.setAttribute("error_msg", "相同");
            session.invalidate(); //设置session失效
        } else {
            session.setAttribute("error_msg", "验证码错误");
            RequestDispatcher dp = request.getRequestDispatcher("/login.jsp");
            dp.forward(request, response);
        }

        System.out.printf("user : %s check_code:%s\n", user.toString(), check_code);

    }
}
