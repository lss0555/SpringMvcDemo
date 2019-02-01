package com.sxkj.exception;

import com.sxkj.common.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 异常全局处理
 * @Author lss0555
 * @Date 2019/2/1/001 15:30
 **/
public class HandleMvException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        CustomException customException = null;
        if (ex instanceof CustomException) {
            customException = (CustomException)ex;
        }else{
            customException = new CustomException("未知错误!");
        }
        String errMsg = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", errMsg);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
