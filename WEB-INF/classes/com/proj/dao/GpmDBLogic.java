package com.proj.dao;

import java.util.List;

import com.proj.models.BdoDetailsBean;
import com.proj.models.GpmDetailsBean;

public interface GpmDBLogic {
	
	public boolean addNewGpm(GpmDetailsBean gpmobj);
	public List<GpmDetailsBean>  getAllGpmDetails();
	public List<GpmDetailsBean>  getSelectiveGpmDetailsByBlock(String block);
	public List<GpmDetailsBean>  getSelectiveGpmDetailsByStatus();

	public GpmDetailsBean loginCheck(String useremail, String password);
	public boolean deleteGpmDetails(String pid);
	
	public boolean updateStatus(String pid);



}
