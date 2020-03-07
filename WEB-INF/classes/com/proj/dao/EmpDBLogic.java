package com.proj.dao;

import java.util.List;

import com.proj.models.EmpDetailsBean;


public interface EmpDBLogic {
	
	public boolean addNewEmpl(EmpDetailsBean empobj);
	public List<EmpDetailsBean>  getAllEmpDetails();
	public List<EmpDetailsBean>  getSelectiveEmpDetailsByBlock(String block);
	public List<EmpDetailsBean>  getSelectiveEmpDetailsByPanchayat(String panchayat);

	public EmpDetailsBean loginCheck(String useremail, String password);
	public boolean deleteEmpDetails(String pid);



}
