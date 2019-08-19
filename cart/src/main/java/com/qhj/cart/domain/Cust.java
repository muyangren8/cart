package com.qhj.cart.domain;

import java.util.Date;

/**
 * 用户类
 * @Author lenovo
 * @date 2019/8/13 10:48
 */
public class Cust {
    private Long id;
    private Long gid;
    private String phone;
    private String cname;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
        return "Cust{" + "id=" + id + ", gid=" + gid + ", phone='" + phone + '\'' + ", cname='" + cname + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
