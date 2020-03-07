package com.proj.models;

import java.io.Serializable;

public class AllotmentBean implements Serializable {
	
	private String projid;
	private String gpmid;
	
	
	public AllotmentBean() {
		super();
	}


	public AllotmentBean(String projid, String gpmid) {
		super();
		this.projid = projid;
		this.gpmid = gpmid;
	}


	public String getProjid() {
		return projid;
	}


	public void setProjid(String projid) {
		this.projid = projid;
	}


	public String getGpmid() {
		return gpmid;
	}


	public void setGpmid(String gpmid) {
		this.gpmid = gpmid;
	}


	@Override
	public String toString() {
		return "AllotmentBean [projid=" + projid + ", gpmid=" + gpmid + "]";
	}
	
	
	
	

}
