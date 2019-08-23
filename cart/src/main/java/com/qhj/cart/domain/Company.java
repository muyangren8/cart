package com.qhj.cart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 集团类
 * @Author lenovo
 * @date 2019/8/13 10:44
 */
public class Company implements Serializable {
    private Long id;
    private Long mid;
    private String gname;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
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
        return "Company{" + "id=" + id + ", mid=" + mid + ", gname='" + gname + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
