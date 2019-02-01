package com.sxkj.controller;

import com.sxkj.aop.LoginAuth;
import com.sxkj.common.CustomException;
import com.sxkj.model.TResult;
import com.sxkj.model.TResultUtils;
import com.sxkj.model.User;
import com.sxkj.service.UserServiceInter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description  用户操作接口
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServiceInter userServiceInter;

    @Resource
    HttpServletRequest request;

    /**
     * @Description  用户登录
     **/
    @LoginAuth(validate = false)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public TResult login(User user){
        return userServiceInter.login(user);
    }

    /**
     * @Description  退出登录
     **/
    @LoginAuth(validate = false)
    @RequestMapping (value = "/loginOut",method = RequestMethod.GET)
    public String loginOut() {
        return userServiceInter.loginOut();
    }


    /**
     * @Description  登录界面
     **/
    @LoginAuth(validate = false)
    @RequestMapping (value = "/login",method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


    /**
     * @Description  用户主页
     **/
    @RequestMapping (value = "/index",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        //视图名称
        view.setViewName("index");
        //传递当前用户信息
        User user = (User) request.getSession().getAttribute("user");
        view.addObject("user",user);
        return view;
    }


//    /**
//     * 用于处理自定义异常
//     * @return
//     */
//    @ExceptionHandler({CustomException.class})
//    @ResponseBody
//    public TResult exception(CustomException e) {
//        return TResultUtils.error(e.getMessage());
//    }
}
