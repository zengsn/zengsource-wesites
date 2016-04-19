package com.gizwits.util;

/**
 * @author Marvel
 * 
 * 定义错误码和消息常量
 */
public enum RetMsg {

    /**
     * 用户模块
     */
    SUCCESS_LOGIN(0, "登陆成功"),
    SUCCESS_REGISTER(0, "注册成功"),
    SUCCESS_UPDATED_PASSWORD(0, "密码修改成功"),
    
    FAILURE_PHONENUMBER_NOT_FOUND(-1, "手机号码不存在"),
    FAILURE_INCORRECT_PASSWORD(-1, "密码错误"),
    FAILURE_INCORRECT_CODE(-1, "验证码错误"),
    FAILURE_PHONENUMBER_ALREADY_EXISTS(-1, "手机号码已存在"),
    FAILURE_REGISTER(-1, "注册失败"),
    FAILURE_USER_NOT_FOUND(-1, "用户不存在"),
    
    /**
     * 成员模块
     */
    FAILURE_MEMBER_NOT_FOUND(-1, "成员不存在"),
    FAILURE_MEMBER_NOT_BELONG_TO_USER(-1, "成员不属于该用户"),
    
    /**
     * 设备模块
     */
    FAILURE_DEVICE_NOT_FOUND(-1, "设备不存在"),
    FAILURE_USER_DEVICE_NOT_FOUND(-1, "用户没有绑定该设备"),
    
    /**
     * 类型模块
     */
    FAILURE_DEVICETYPE_NOT_FOUND(-1, "设备类型不存在"),
    
    /**
     * 通用
     */
    SUCCESS(0, "成功"),
    SUCCESS_CREATED(0, "创建成功"),
    SUCCESS_UPDATED(0, "修改成功"),
    SUCCESS_DELETED(0, "删除成功"),
    SUCCESS_NO_CONTENT(0, "没有内容"),
    
    FAILURE(-1, "失败"),
    FAILURE_CREATED(-1, "创建失败"),
    FAILURE_UPDATED(-1, "修改失败"),
    FAILURE_DELETED(-1, "删除失败"),
    FAILURE_NAME_FORMAT(-1, "名称格式不合法"),
    FAILURE_NAME_ALREADY_EXISTS(-1, "名称已存在"),
    
    ERROR_PARAM_FORMAT(-1, "参数格式错误"),
    ERROR_DATE_FORMAT(-1, "日期格式错误");
    
    private final Integer ret;
    private final String msg;
    
    RetMsg(Integer ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }
    
    public Integer getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }
    
}
