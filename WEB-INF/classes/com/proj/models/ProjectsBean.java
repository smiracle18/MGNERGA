package com.proj.models;

import java.io.Serializable;
import java.util.Date;

public class ProjectsBean implements Serializable{
	
	private String projid;
	private String projname;
	private Date projstartdate;
	private int projcapacity;
	private int projstatus;
	private String block;
	private String panchayat;
	
	
	public ProjectsBean() {
		super();
	}


	public ProjectsBean(String projid, String projname, Date projstartdate, int projcapacity, int projstatus,
			String block, String panchayat) {
		super();
		this.projid = projid;
		this.projname = projname;
		this.projstartdate = projstartdate;
		this.projcapacity = projcapacity;
		this.projstatus = projstatus;
		this.block = block;
		this.panchayat = panchayat;
	}


	public String getProjid() {
		return projid;
	}


	public void setProjid(String projid) {
		this.projid = projid;
	}


	public String getProjname() {
		return projname;
	}


	public void setProjname(String projname) {
		this.projname = projname;
	}


	public Date getProjstartdate() {
		return projstartdate;
	}


	public void setProjstartdate(Date projstartdate) {
		this.projstartdate = projstartdate;
	}


	public int getProjcapacity() {
		return projcapacity;
	}


	public void setProjcapacity(int projcapacity) {
		this.projcapacity = projcapacity;
	}


	public int getProjstatus() {
		return projstatus;
	}


	public void setProjstatus(int projstatus) {
		this.projstatus = projstatus;
	}


	public String getBlock() {
		return block;
	}


	public void setBlock(String block) {
		this.block = block;
	}


	public String getPanchayat() {
		return panchayat;
	}


	public void setPanchayat(String panchayat) {
		this.panchayat = panchayat;
	}


	@Override
	public String toString() {
		return "ProjectsBean [projid=" + projid + ", projname=" + projname + ", projstartdate=" + projstartdate
				+ ", projcapacity=" + projcapacity + ", projstatus=" + projstatus + ", block=" + block + ", panchayat="
				+ panchayat + "]";
	}


	

	
	
	

}
