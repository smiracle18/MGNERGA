package com.proj.models;

import java.io.Serializable;

public class PanchayatsBean implements Serializable{
	
	private String pname;
	private String bname;
	private int psize;
	
	
	
	public PanchayatsBean() {
		super();
	}



	public PanchayatsBean(String pname, String bname, int psize) {
		super();
		this.pname = pname;
		this.bname = bname;
		this.psize = psize;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public String getBname() {
		return bname;
	}



	public void setBname(String bname) {
		this.bname = bname;
	}



	public int getPsize() {
		return psize;
	}



	public void setPsize(int psize) {
		this.psize = psize;
	}



	@Override
	public String toString() {
		return "PanchayatsBean [pname=" + pname + ", bname=" + bname + ", psize=" + psize + "]";
	}
	
	

}
