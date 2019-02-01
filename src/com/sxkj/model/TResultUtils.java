package com.sxkj.model;

import java.util.List;

/**
 * @Description model模型工具类
 * @Author lss0555
 * @Date 2019/1/31/031 9:07
 **/
public class TResultUtils extends TResult {

    /**
     * @Description  返回错误信息
     **/
    public static TResult error(String msg) {
        TResult result = new TResult();
        result.setErrorCode(-1);
        result.setErrorMsg(msg);
        return result;
    }

    /**
     * @Description  返回成功
     **/
    public static TResult success() {
        return new TResult();
    }

    /**
     * @Description  返回成功信息,加data
     **/
    public static TResult success(Object data) {
        TResult result = new TResult();
        result.setData(data);
        return result;
    }

}
