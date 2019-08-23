package com.qhj.cart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * @Author lenovo
 * @date 2019/8/13 10:48
 */
public class Cust implements Serializable {
    private Long id;//客户id
    private Long gid;//集团id
    private String phone;
    private String cname;//客户名字
    private Date createTime;
    private Date updateTime;
    private Integer status;//客户协议签订状态  0：未签订，1：已签订

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


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cust{" + "id=" + id + ", gid=" + gid + ", phone='" + phone + '\'' + ", cname='" + cname + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + ", status=" + status + '}';
    }
}
