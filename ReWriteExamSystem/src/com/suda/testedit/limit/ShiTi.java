package com.suda.testedit.limit;

public class ShiTi {
	private String id;
	private String subject;
	private String wenti;
	private String daan;
	private String zhishidian;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWenti() {
		return wenti;
	}
	public void setWenti(String wenti) {
		this.wenti = wenti;
	}
	public String getDaan() {
		return daan;
	}
	public void setDaan(String daan) {
		this.daan = daan;
	}
	public String getZhishidian() {
		return zhishidian;
	}
	public void setZhishidian(String zhishidian) {
		this.zhishidian = zhishidian;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString(){
	    return "题号: " + this.id + "问题:" + this.wenti+ 
	    		"答案:" + this.daan+ "知识点:" + this.zhishidian+ "学科:" + this.subject;
	}
	public String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
