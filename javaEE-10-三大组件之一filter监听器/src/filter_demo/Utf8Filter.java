package filter_demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Utf8Filter implements Filter {
    public void destroy() {
        System.out.printf("过滤器销毁\n");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.printf("req characterEncoding:%s\n", req.getCharacterEncoding());
        req.setCharacterEncoding("utf-8");
        String characterEncoding = resp.getCharacterEncoding();
        System.out.printf("characterEncoding:%s\n", characterEncoding);
        System.out.println("filter hhhhh");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.printf("过滤器出生 init : config[%s]\n", config);
    }

}
