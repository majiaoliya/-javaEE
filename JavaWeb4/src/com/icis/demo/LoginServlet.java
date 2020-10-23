package com.icis.demo;

import com.icis.dao.UserDao;
import com.icis.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           System.out.println("登录请求到达了");
           //设置编码
           request.setCharacterEncoding("utf-8");
           //获得用户名和密码
           Map<String, String[]> userMap = request.getParameterMap();
           //把数据封装到user对象中
           User user=new User();
           //封装map中数据到User对象
           BeanUtils.populate(user,userMap);
          //调用Userdao  执行查询
           UserDao userDao=new UserDao();
           User dbUser = userDao.getUserByNameAndPwd(user);
           //跳转到成功能的servlet
           //设置用户名
           request.setAttribute("username",dbUser.getUsername());
           request.getRequestDispatcher("/success").forward(request,response);
       }catch (Exception e){
           String string = e.getMessage();
           //创建一个文件
           //FileWriter fileWriter=new FileWriter(new File("/"))
          // 记录日志  把异常信息  记录到一个日志表中
          //跳转到失败的servlet
           request.getRequestDispatcher("/fail").forward(request,response);
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
