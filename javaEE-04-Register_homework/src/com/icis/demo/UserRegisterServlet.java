package com.icis.demo;

import com.icis.dao.UserDao;
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
import java.util.Date;
import java.util.Map;
import java.util.Set;

@WebServlet("/web4/userRegister")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        User user = new User();
        try {
            Map<String, String[]> mp = request.getParameterMap();
            String birthday = "birthday";
//            String[] birthdays = mp.get(key);
//            mp.remove(key);
//            BeanUtils.populate(user, mp);
            Set<Map.Entry<String, String[]>> entries = mp.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                String key = entry.getKey();
                String[] value = entry.getValue();
                if(key.equals(birthday)) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    date = sdf.parse(value[0]);
                    user.setBirthday(date);
                } else {
                    BeanUtils.setProperty(user, key, value[0]);
                }
            }
            int status = dao.addUserToDB(user);
            if(status > 0) { //注册成功后  跳转到首页 首页显示  注册成功,欢迎XXX
                request.setAttribute("user", user);
                RequestDispatcher dip = request.getRequestDispatcher("/register_ok");
                dip.forward(request, response);
            } else { //注册失败    重新返回到注册页面
                String back_url = request.getContextPath()+"/html/register.html";
                response.sendRedirect(back_url);
                System.out.printf("back_url:%s\n", back_url);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
