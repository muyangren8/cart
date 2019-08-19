package com.qhj.cart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 协议对象
 * @Author lenovo
 * @date 2019/8/17 15:59
 */
public class Sign implements Serializable {
    private Long id;
    private Long mid;
    private String mname;
    private Long gid;
    private String gname;
    private Long cid;
    private String cname;
    private Date planStartDate;
    private Date planEndDate;
    private String signatureImageA;
    private String signatureImageB;
    private Date signDateA;
    private Date signDateB;

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

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getSignatureImageA() {
        return signatureImageA;
    }

    public void setSignatureImageA(String signatureImageA) {
        this.signatureImageA = signatureImageA;
    }

    public String getSignatureImageB() {
        return signatureImageB;
    }

    public void setSignatureImageB(String signatureImageB) {
        this.signatureImageB = signatureImageB;
    }

    public Date getSignDateA() {
        return signDateA;
    }

    public void setSignDateA(Date signDateA) {
        this.signDateA = signDateA;
    }

    public Date getSignDateB() {
        return signDateB;
    }

    public void setSignDateB(Date signDateB) {
        this.signDateB = signDateB;
    }

    @Override
    public String toString() {
        return "Sign{" + "id=" + id + ", mid=" + mid + ", mname='" + mname + '\'' + ", gid=" + gid + ", gname='" + gname + '\'' + ", cid=" + cid + ", cname='" + cname + '\'' + ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", signatureImageA='" + signatureImageA + '\'' + ", signatureImageB='" + signatureImageB + '\'' + ", signDateA=" + signDateA + ", signDateB=" + signDateB + '}';
    }
}
