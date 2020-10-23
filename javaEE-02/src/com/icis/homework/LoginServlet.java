package com.icis.homework;

import com.icis.pojo.User;
import com.icis.utils.DataSourceUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"),
               password = request.getParameter("password");
        RequestDispatcher login_ok = request.getRequestDispatcher("/login_ok"),
                          login_fail = request.getRequestDispatcher("/login_fail");
        try {
            JdbcTemplate tmp = new JdbcTemplate(DataSourceUtils.getDs());
//            Map<String, Object> mp = tmp.queryForMap("select * from user where username=? AND PASSWORD=?", username, password);
            String sql = "select * from user where username=? AND PASSWORD=?";
            String args[] = new String [2];
            args[0] = username; args[1] = password;
            List<User> list = tmp.query(sql, args, new BeanPropertyRowMapper<User>(User.class));
            if(list.isEmpty()) {
                login_fail.forward(request, response);
            } else {
                request.setAttribute("list", list);
                login_ok.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void func() throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(DataSourceUtils.getDs());
//        Map<String, Object> mp = tmp.queryForMap("select * from emp where id=1");
//        System.out.println(mp);
        String sql = "select * from user WHERE username=? AND PASSWORD=?";
        String args[] = new String [2];
        String username = "abc", password = "12345ss6";
        args[0] = username; args[1] = password;
        List<User> list = tmp.query(sql, args, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
