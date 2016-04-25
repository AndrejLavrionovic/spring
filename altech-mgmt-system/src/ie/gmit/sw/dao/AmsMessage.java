package ie.gmit.sw.dao;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class AmsMessage {

	private int msgid;
	private int empnum;
	private Date date;
	private String msg;
	
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// CONSTRUCRTORS
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public AmsMessage(){}
	
	public AmsMessage(int msgid, int empnum, Date date, String msg) {
		this.msgid = msgid;
		this.empnum = empnum;
		this.date = date;
		this.msg = msg;
	}
	

	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	// GETTERS/SETTERS
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	public int getMsgid() {
		return msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public int getEmpnum() {
		return empnum;
	}

	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
