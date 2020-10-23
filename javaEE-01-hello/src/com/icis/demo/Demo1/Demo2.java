package com.icis.demo.Demo1;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo2 implements Servlet {
    int i = 0;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello ");
        PrintWriter out = servletResponse.getWriter();
        out.printf("%s [%d]\n", this.toString(), ++i);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
