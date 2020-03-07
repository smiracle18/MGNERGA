package com.proj.models;

import java.io.Serializable;

public class BlocksBean implements Serializable {
	
	private String bname;
	private int bsize;
	
	
	
	public BlocksBean() {
		super();
	}



	public BlocksBean(String bname, int bsize) {
		super();
		this.bname = bname;
		this.bsize = bsize;
	}



	public String getBname() {
		return bname;
	}



	public void setBname(String bname) {
		this.bname = bname;
	}



	public int getBsize() {
		return bsize;
	}



	public void setBsize(int bsize) {
		this.bsize = bsize;
	}



	@Override
	public String toString() {
		return "BlocksBean [bname=" + bname + ", bsize=" + bsize + "]";
	}
	

}
