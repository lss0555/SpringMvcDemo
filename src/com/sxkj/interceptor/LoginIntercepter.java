package com.sxkj.interceptor;

import com.sxkj.aop.LoginAuth;
import com.sxkj.model.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * 用户登录状态拦截器
 */
public class LoginIntercepter implements HandlerInterceptor {
    private List<String> exceptUrls;

    /**
     *
     * 该方法将在Controller处理之前进行调用  1298  50  468  295 139 188
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        LoginAuth loginAuth = ((HandlerMethod) o).getMethodAnnotation(LoginAuth.class);

        //条件刷选,为false的不用拦截判断
//        if (loginAuth != null && !loginAuth.validate()) {
//            return true;
//        }

        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }
    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
     * 也就是说在这个方法中你可以对ModelAndView进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.print("拦截器PostHandle");
    }
    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.print("拦截器afterCompletion");
    }

}
