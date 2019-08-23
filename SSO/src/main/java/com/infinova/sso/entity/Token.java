package com.infinova.sso.entity;

/**
 * 用户类
 * @Author lenovo
 * @date 2019/8/13 10:48
 */
public class Token {
    private String name;
    private String sign;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Token{"  + ", name='" + name + '\'' + ", sign='" + sign + '\'' + '}';
    }
}
