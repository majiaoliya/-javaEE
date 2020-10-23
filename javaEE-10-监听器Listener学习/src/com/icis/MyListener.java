package com.icis;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    //创建ServletContext时触发的方法
    @Override
    public void contextInitialized(ServletContextEvent even) {
        System.out.println("majiao_create ServletContext创建了");

        ServletContext servletContext = even.getServletContext();
        String dbFile = servletContext.getInitParameter("dbFile");
        System.out.printf("获得属性文件路径 : %s\n", dbFile);
    }

    //创建ServletContext时销毁的方法
    @Override
    public void contextDestroyed(ServletContextEvent even) {
        System.out.println("majiao_die");
    }
}
