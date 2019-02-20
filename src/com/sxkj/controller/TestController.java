package com.sxkj.controller;

import com.sxkj.common.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 测试
 * @Author lss0555
 * @Date 2019/2/1/001 15:46
 **/
@Controller
public class TestController {

    /**
     * @Description  测试空指针异常  ArithmeticException
     **/
    @RequestMapping("/test_null")
    public String test_null(){
        int c=1/0;
        return "/login";
    }


    /**
     * @Description  测试异常
     **/
    @RequestMapping("/test_error_msg")
    public String test_error_msg() {
        int c=0;
        if(c==0){
            throw  new CustomException("空指针异常...");
        }

        return "/login";
    }


    /**
     * @Description  测试url_pattern匹配规则 /  与/*的区别
     * 这里的url-pattern不能写成/*，因为DispatcherServlet会将向动态页面的跳转请求，
     * 即向JSP页面的跳转请求也当成一个普通的Controller请求
     **/
    @RequestMapping("/loginTest.do")
    public String test_url_pattern() {
        return "/login";
    }


        @RequestMapping("test_error")
    @ResponseBody
    public void test() {
        throw new CustomException("出错了！");
    }

}
