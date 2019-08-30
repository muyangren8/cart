package com.market.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作经理类
 * @Author lenovo
 * @date 2019/8/13 10:39
 */
public class Manager implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Manager{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", realName='" + realName + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
