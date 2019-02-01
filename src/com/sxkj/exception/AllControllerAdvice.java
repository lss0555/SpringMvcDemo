//package com.sxkj.exception;
//
//import com.sxkj.common.CustomException;
//import com.sxkj.model.TResult;
//import com.sxkj.model.TResultUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.HttpMediaTypeNotSupportedException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
///**
// * Description 全局异常捕获
// */
//@ControllerAdvice
//@ResponseBody
//public class AllControllerAdvice {
//
//    /**
//     * 用于处理自定义异常
//     * @return
//     */
//    @ExceptionHandler({CustomException.class})
//    public TResult exception(CustomException e) {
//        return TResultUtils.error(e.getMessage());
//    }
//
//
//    /**
//     * @Description  400 - Bad Request
//     **/
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public TResult handleBadRequst(Exception e) {
//        return TResultUtils.error(e.getMessage());
//    }
//
//
//    /**
//     * @Description  405 - Method Not Allowed
//     **/
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public TResult handleMethodNotAllowed(Exception e) {
//        return TResultUtils.error(e.getMessage());
//    }
//
//
//    /**
//     * @Description  415 - Unsupported Media Type
//     **/
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//    public TResult handleUnsupportedMediaType(Exception e) {
//        return TResultUtils.error(e.getMessage());
//    }
//
//
//    /**
//     * @Description  500
//     **/
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public TResult handleIOException(Exception e) {
//        return TResultUtils.error(e.getMessage());
//    }
//}
