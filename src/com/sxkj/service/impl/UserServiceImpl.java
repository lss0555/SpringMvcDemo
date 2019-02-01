package com.sxkj.service.impl;

import com.sxkj.common.CustomException;
import com.sxkj.model.TResult;
import com.sxkj.model.TResultUtils;
import com.sxkj.model.User;
import com.sxkj.service.UserServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description 用户操作实现类
 * @Author lss0555
 **/
@Service
public class UserServiceImpl implements UserServiceInter{
    @Resource
    HttpServletRequest request;

    /**
     * @Description  用户登录
     **/
    @Override
    public TResult login(User user) {
        //参数验证
        if(user.getUsername()==null||user.getUsername().equals("")
               ||user.getPassword()==null||user.getPassword().equals("") ){
            throw new CustomException("请输入完整");
        }

        //模拟数据库查询耗时操作
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //身份验证
        if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")){
            request.getSession().setAttribute("user",user);
            return TResultUtils.success();
        }
        throw new CustomException("请检查您的用户名或者密码是否正确");
    }

    /**
     * @Description  退出登录
     **/
    @Override
    public String loginOut() {
        request.getSession().removeAttribute("user");
        return "redirect:/user/login";
    }
}
