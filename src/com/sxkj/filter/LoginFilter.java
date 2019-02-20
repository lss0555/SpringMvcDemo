package com.sxkj.filter;

import com.sxkj.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 登录过滤器
 * @Author lss0555
 **/
public class LoginFilter implements Filter {
    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化...");
        excludedPages = filterConfig.getInitParameter("excludedPages");
        if (null != excludedPages && excludedPages.length() > 0) {
            excludedPageArray = excludedPages.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器doFilter...");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String contextPath = request.getServletContext().getContextPath();
        String uri = request.getRequestURI();
        uri = uri.substring(contextPath.length());
        //过滤无需处理的请求
//        if (uri.equals("/user/login") || uri.equals("/user/loginOut")) {
//            //通过
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }


        //过滤无需处理的请求
        for (String page : excludedPageArray) {
            if(page.equals(uri)){
                filterChain.doFilter(servletRequest, servletResponse);
                 return;
            }
        }


        //拦截处理
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/user/login");
    }

}

    @Override
    public void destroy() {
        System.out.println("过滤器销毁...");
    }
}
