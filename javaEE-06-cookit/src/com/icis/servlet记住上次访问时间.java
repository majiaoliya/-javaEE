package com.icis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/show_time")
public class servlet记住上次访问时间 extends HttpServlet {
    public static final String LST_TIME = "LST_TIME";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cs = request.getCookies();
        if(cs.length > 0) {
            for (Cookie c : cs) {
                if(c.getName().equals(LST_TIME)) {
                    String time_str = c.getValue();
                    String decode = URLDecoder.decode(c.getValue());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    PrintWriter out = response.getWriter();
                    out.printf("<h1>last Request Time : %s</h1>", decode);
                    Date date = new Date();
                    c.setMaxAge(60*60);
                    String encode_str = URLEncoder.encode(date.toString(), "utf-8");
                    c.setValue(encode_str);
                    response.addCookie(c);
                    return ;
                }
            }
        }
        PrintWriter out = response.getWriter();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Cookie cookie = new Cookie(LST_TIME, URLEncoder.encode(sdf.format(date), "utf-8"));
        response.addCookie(cookie);
        out.printf("<h1>last Request Time : You are First</h1>");
    }
}
