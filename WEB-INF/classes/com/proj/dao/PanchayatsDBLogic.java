package com.proj.dao;

import java.util.List;

import com.proj.models.BlocksBean;
import com.proj.models.PanchayatsBean;





public interface PanchayatsDBLogic {
	
	
	public List<PanchayatsBean>  getAllPanchayats();
	public List<PanchayatsBean>  getPanchayatsOfBlock(String block);

	public boolean insertPanchayat(PanchayatsBean panchayat);

}
