package demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/B")
public class ServletB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object fuck = request.getAttribute("fuck");
        System.out.println(fuck);
        response.getWriter().printf("<h1>%s</h1>", fuck);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object fuck = request.getAttribute("fuck");
        System.out.println(fuck);
        response.getWriter().printf("<h1>%s</h1>", fuck);
    }
}
