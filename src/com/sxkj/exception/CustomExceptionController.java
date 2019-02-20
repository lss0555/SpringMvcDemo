package com.sxkj.exception;

import com.sxkj.common.CustomException;
import com.sxkj.model.TResult;
import com.sxkj.model.TResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 自定义异常处理
 * @Author lss0555
 **/
@Controller
public class CustomExceptionController {

    /**
     * 用于处理自定义异常
     * @return
     */
//    @ExceptionHandler({CustomException.class})
//    @ResponseBody
//    public TResult handleException(CustomException e) {
//        return TResultUtils.error(e.getMessage());
//    }

//    @RequestMapping("test_error")
//    @ResponseBody
//    public void test() {
//        throw new CustomException("出错了！");
//    }
}
