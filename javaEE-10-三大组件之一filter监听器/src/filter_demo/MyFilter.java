package filter_demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//  /*表示 过滤所有请求
@WebFilter("/*")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
