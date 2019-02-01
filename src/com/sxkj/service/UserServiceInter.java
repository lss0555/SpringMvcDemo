package com.sxkj.service;

import com.sxkj.model.TResult;
import com.sxkj.model.User;

/**
 * @Description 用户相关操作
 * @Author lss0555
 **/
public interface UserServiceInter {
    TResult login(User user);//用户登录
    String loginOut();       //用户退出
}
