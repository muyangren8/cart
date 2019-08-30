package com.qhj.cart.domain;

import java.io.Serializable;
import java.util.Arrays;
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
    private String plan;
    private Date planStartDate;
    private Date planEndDate;
    private String signatureImageA;
    private String signatureImageB;
    private byte[] imageA;
    private byte[] imageB;
    private Date signDateA;
    private Date signDateB;

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

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

    public byte[] getImageA() {
        return imageA;
    }

    public void setImageA(byte[] imageA) {
        this.imageA = imageA;
    }

    public byte[] getImageB() {
        return imageB;
    }

    public void setImageB(byte[] imageB) {
        this.imageB = imageB;
    }

    @Override
    public String toString() {
        return "Sign{" + "id=" + id + ", mid=" + mid + ", mname='" + mname + '\'' + ", gid=" + gid + ", gname='" + gname + '\'' + ", cid=" + cid + ", cname='" + cname + '\'' + ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", signatureImageA='" + signatureImageA + '\'' + ", signatureImageB='" + signatureImageB + '\'' + ", imageA=" + Arrays.toString(imageA) + ", imageB=" + Arrays.toString(imageB) + ", signDateA=" + signDateA + ", signDateB=" + signDateB + '}';
    }
}
