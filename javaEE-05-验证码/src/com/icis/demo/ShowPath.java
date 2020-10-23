package com.icis.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/showPath")
public class ShowPath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext con = request.getServletContext();
        String realPath = con.getRealPath("/a.txt");
        PrintWriter out = response.getWriter();
        output(out, System.out, "a.txt", realPath);
        output(out, System.out, "majiao", con.getRealPath("/WEB-INF/classes/majiao"));
    }
    void output(PrintWriter out, PrintStream out2, String lef, String s) {
        out.printf("%s : %s\n", lef, s);
        out2.printf("%s : %s\n", lef, s);
    }
}
