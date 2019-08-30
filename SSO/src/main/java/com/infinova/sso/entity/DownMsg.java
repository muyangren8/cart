package com.market.domain;

/**
 * 下行
 * 
 * @author Administrator
 * 
 */
public class DownMsg {
	/** 消息类型：Submit */
	private String MSGTYP = "Submit";
	/** 从1不断增长 */
	private String SEQID = "34920";
	/** 下行目的号码 */
	private String DESTADDR = "";
	/** 号码类型：0为手机号码，1为伪码 */
	private String DESTADDRTYPE = "0";
	/** 源号码 */
	private String SRCADDR = "106582805";
	/** 消息内容,WAP Push时存入Push地址 */
	private String MSG = "宁波网络服务站系统：您在宁波网络服务站下有投诉工单需要处理。";
	/** 栏目ID */
	private String TOPID = "TEST";
	/** 业务代码 */
	private String SRVCODE = "8280";
	/** 网关编号 */
	private String MASTERID = "004";
	/** 消息格式类型。 0：ASCII串 4：二进制信息； 8：UCS2编码； 15：含GB汉字...... 6:WAP Push*/
	private String MSGFMT = "15";
	/** TPPID。GSM协议类型。详细是解释请参考GSM03.40中的9.2.3.9。 */
	private String TPPID = "0";
	/** TPUDHI。GSM协议类型。详细是解释请参考GSM03.40中的9.2.3.23,仅使用1位，右对齐。 */
	private String TPUDHI = "0";
	/** 企业ID */
	private String CORID = "100002";
	/** LINKID */
	private String LINKID = "1234567890";
	/** 命令ID,WAP Push时存放短信内容 */
	private String CMDID = "03";
	/** 版本 */
	private String VER = "1.0";

	public DownMsg() {
	}

	public DownMsg(String destaddr) {
		DESTADDR = destaddr;
	}

	public DownMsg(String destaddr, String msg) {
		DESTADDR = destaddr;
		MSG = msg;
	}

	public DownMsg(String destaddr, String msg, String cmdid) {
		DESTADDR = destaddr;
		MSG = msg;
		CMDID = cmdid;
	}

	@Override
	public String toString() {
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?><ROOT><MSGTYP>"
				+ MSGTYP + "</MSGTYP><SEQID>" + SEQID + "</SEQID><DESTADDR>"
				+ DESTADDR + "</DESTADDR><DESTADDRTYPE>" + DESTADDRTYPE
				+ "</DESTADDRTYPE><SRCADDR>" + SRCADDR + "</SRCADDR><MSG>"
				+ MSG + "</MSG><TOPID>" + TOPID + "</TOPID><SRVCODE>" + SRVCODE
				+ "</SRVCODE><MASTERID>" + MASTERID + "</MASTERID><MSGFMT>"
				+ MSGFMT + "</MSGFMT><TPPID>" + TPPID + "</TPPID><TPUDHI>"
				+ TPUDHI + "</TPUDHI><CORID>" + CORID + "</CORID><LINKID>"
				+ LINKID + "</LINKID><CMDID>" + CMDID + "</CMDID><VER>" + VER
				+ "</VER></ROOT>";
	}

	public String getMSGTYP() {
		return MSGTYP;
	}

	public void setMSGTYP(String msgtyp) {
		MSGTYP = msgtyp;
	}

	public String getSEQID() {
		return SEQID;
	}

	public void setSEQID(String seqid) {
		SEQID = seqid;
	}

	public String getDESTADDR() {
		return DESTADDR;
	}

	public void setDESTADDR(String destaddr) {
		DESTADDR = destaddr;
	}

	public String getDESTADDRTYPE() {
		return DESTADDRTYPE;
	}

	public void setDESTADDRTYPE(String destaddrtype) {
		DESTADDRTYPE = destaddrtype;
	}

	public String getSRCADDR() {
		return SRCADDR;
	}

	public void setSRCADDR(String srcaddr) {
		SRCADDR = srcaddr;
	}

	public String getMSG() {
		return MSG;
	}

	public void setMSG(String msg) {
		MSG = msg;
	}

	public String getTOPID() {
		return TOPID;
	}

	public void setTOPID(String topid) {
		TOPID = topid;
	}

	public String getSRVCODE() {
		return SRVCODE;
	}

	public void setSRVCODE(String srvcode) {
		SRVCODE = srvcode;
	}

	public String getMASTERID() {
		return MASTERID;
	}

	public void setMASTERID(String masterid) {
		MASTERID = masterid;
	}

	public String getMSGFMT() {
		return MSGFMT;
	}

	public void setMSGFMT(String msgfmt) {
		MSGFMT = msgfmt;
	}

	public String getTPPID() {
		return TPPID;
	}

	public void setTPPID(String tppid) {
		TPPID = tppid;
	}

	public String getTPUDHI() {
		return TPUDHI;
	}

	public void setTPUDHI(String tpudhi) {
		TPUDHI = tpudhi;
	}

	public String getCORID() {
		return CORID;
	}

	public void setCORID(String corid) {
		CORID = corid;
	}

	public String getLINKID() {
		return LINKID;
	}

	public void setLINKID(String linkid) {
		LINKID = linkid;
	}

	public String getCMDID() {
		return CMDID;
	}

	public void setCMDID(String cmdid) {
		CMDID = cmdid;
	}

	public String getVER() {
		return VER;
	}

	public void setVER(String ver) {
		VER = ver;
	}

}
