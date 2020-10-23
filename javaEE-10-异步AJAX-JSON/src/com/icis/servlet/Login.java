package com.icis.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    ObjectMapper mp = new ObjectMapper();
    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        response.setCharacterEncoding("utf-8");

//        User user = new User("山雨", "12347777");
        Integer ret = service.findUserByUsername(username);
        Msg msg = new Msg();
        System.out.println(ret);
        if(ret > 0) msg.msg = "用户名重复";
        else msg.msg = "可以使用";

        String json = mp.writeValueAsString(msg);
        System.out.println(json );

        response.getWriter().write(json);
        response.getWriter().flush();
    }
}

class Msg {
    public String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg() {
    }

    public Msg(String msg) {
        this.msg = msg;
    }
}
