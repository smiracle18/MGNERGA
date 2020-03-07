package com.proj.dao;

import java.util.List;

import com.proj.models.BdoDetailsBean;
import com.proj.models.GpmDetailsBean;

public interface BdoDBLogic {
	
	public boolean insertBdo(BdoDetailsBean bdoobj);
	public List<BdoDetailsBean>  getAllBdoDetails();
	public BdoDetailsBean loginCheck(String useremail, String password);
	public boolean deleteBdoDetails(String pid);
	public BdoDetailsBean getBdoDetailsOf(String pid);

	
	/*public boolean createNewProject();
	//view list of projects
	public boolean allocatePoject(GpmDetailsBean gpmobj);
	
	//public List<employee>*/
	
	

}
