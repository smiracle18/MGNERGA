package com.proj.models;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BdoDetailsBean implements Serializable {
	
	private String pid;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private String phoneno;
	private String sex;
	private String block;
	private int status;
	
	
	public BdoDetailsBean() {
		super();
		
	}


	public BdoDetailsBean(String pid, String name, String email, String password, Date dob, String phoneno, String sex,
			String block, int status) {
		super();
		this.pid = pid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.phoneno = phoneno;
		this.sex = sex;
		this.block = block;
		this.status = status;
	}


	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBlock() {
		return block;
	}


	public void setBlock(String block) {
		this.block = block;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "BdoDetailsBean [pid=" + pid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", dob=" + dob + ", phoneno=" + phoneno + ", sex=" + sex + ", block=" + block + ", status=" + status
				+ "]";
	}	
	
	
		
	

}
