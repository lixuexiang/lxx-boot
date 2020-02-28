package com.ke.common;

public class ResponseResult<T> {
    // 未登录
    public static final String UN_LOGIN_CODE = "401";
    // 操作失败
    public static final String ERROR_CODE = "400";
    // 服务器内部执行错误
    public static final String UNKNOWN_ERROR_CODE = "500";
    // 操作成功
    public static final String SUCCESS_CODE = "200";
    // 响应信息
    private String msg;
    // 响应code
    private String code;
    // 操作成功，响应数据
    private T data;

    public ResponseResult(String code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
