package com.gizwits.util;

import java.io.Serializable;

/**
 * @author Marvel
 * 
 * 接口返回格式，接口v1.1
 */
public class FormattedResult implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // 错误代码
    private Integer ret;
    // 数据
    private Object data;
    // 提示信息
    private String msg;
    
    public FormattedResult() {
    }
    
    public FormattedResult(Object data, RetMsg rm) {
        this.ret = rm.getRet();
        this.data = data;
        this.msg = rm.getMsg();
    }
    
    public FormattedResult(RetMsg rm) {
        this.ret = rm.getRet();
        this.msg = rm.getMsg();
    }
    
    public FormattedResult set(Object data, RetMsg rm) {
        this.ret = rm.getRet();
        this.data = data;
        this.msg = rm.getMsg();
        return this;
    }
    
    public FormattedResult set(RetMsg rm) {
        this.ret = rm.getRet();
        this.msg = rm.getMsg();
        return this;
    }
    
    // get、set方法

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
