package com.atguigu.utils;

/*
返回结果类
 */

public class R {
    // Field，初始化
    private int code = 200;        //返回200状态码

    private boolean flag = true;   //返回状态

    private Object data;          //返回具体数据

    // 完全没问题，把具体数据赋给data就行，其他两个属性就是默认值
    public static R ok(Object data){
        R r = new R();
        r.data = data;
        return r;
    }

    // 失败的情况
    public static R fail(Object data) {
        R r = new R();
        r.code = 500;   //未获取到数据的状态码 500
        r.flag = false;
        r.data = data;
        return r;
    }

    // getter和setter方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
