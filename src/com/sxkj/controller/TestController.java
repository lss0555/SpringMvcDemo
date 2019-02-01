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
     * @Description  测试空指针异常
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
}
