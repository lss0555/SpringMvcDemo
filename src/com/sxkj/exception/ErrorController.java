package com.sxkj.exception;

import com.sxkj.aop.LoginAuth;
import com.sxkj.model.TResult;
import com.sxkj.model.TResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 错误提示
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {
    /**
     * 错误:404
     */
    @LoginAuth(validate = false)
    @RequestMapping(value = "/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String error404() {
        return "404";
    }


    /**
     * 错误:500
     */
    @LoginAuth(validate = false)
    @RequestMapping(value = "/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String error500() {
        return "500";
    }

    /**
     * 错误:空指针异常
     */
    @LoginAuth(validate = false)
    @RequestMapping(value = "/null")
    public String error_null() {
        return "null";
    }

    /**
     * 错误:未捕获异常
     */
    @RequestMapping(value = "/uncaughtException")
    @ResponseBody
    public TResult uncaughtException(Exception e) {
        e.printStackTrace();
        return TResultUtils.error(e.getMessage());
    }
}
