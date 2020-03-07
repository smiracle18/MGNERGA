package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj.models.EmpDetailsBean;

public class EmpDBImpl implements EmpDBLogic {

	
	
	
	
	@Override
	public boolean addNewEmpl(EmpDetailsBean empobj) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("insert into emp_details values(?,?,?,?,?,?,?,?,?,?,?,?,?)");  // number of questions marks
																							// Is equal to number of tables   
			
			ps.setString(1,empobj.getPid());
			ps.setString(2,empobj.getName());
			ps.setString(3,empobj.getEmail());
			ps.setString(4,empobj.getPassword());
			
			java.sql.Date sdate=new java.sql.Date(empobj.getDob().getTime());
			ps.setDate(5,sdate);
			
			ps.setString(6,empobj.getSex());
			ps.setString(7,null);
			ps.setString(8,null);
			ps.setString(9, empobj.getPhoneno());
			ps.setInt(10,0);
			ps.setString(11,null);
			ps.setInt(12,0);
			ps.setInt(13,0);
			
			
			
			int i=ps.executeUpdate();
			System.out.println(i);
			if(i>0)
				f=true;
			
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
		
		finally {  // finally is used for closing mechanism
			
				try {
					if(conn != null)
						conn.close();
					if(ps!=null)
						ps.close();
				}catch (Exception e) {
					System.out.println(e.toString());
				}
		
		}
		
		
		return f;	
	}

	
	
	
	
	
	@Override
	public List<EmpDetailsBean> getAllEmpDetails() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		EmpDetailsBean userobj=null;			
		List<EmpDetailsBean> userobjs=new ArrayList<EmpDetailsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from emp_details");

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new EmpDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						userobj.setStatus(Integer.parseInt(rs.getString(10)));
						userobj.setDesignation(rs.getString(11));
						userobj.setAttendance(Integer.parseInt(rs.getString(12)));
						userobj.setSalary(Integer.parseInt(rs.getString(13)));
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}

	@Override
	public List<EmpDetailsBean> getSelectiveEmpDetailsByBlock(String block) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		EmpDetailsBean userobj=null;			
	
		List<EmpDetailsBean> userobjs=new ArrayList<EmpDetailsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from emp_details where block=?");
				ps.setString(1, block);

				

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new EmpDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						userobj.setStatus(Integer.parseInt(rs.getString(10)));
						userobj.setDesignation(rs.getString(11));
						userobj.setAttendance(Integer.parseInt(rs.getString(12)));
						userobj.setSalary(Integer.parseInt(rs.getString(13)));
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}

	@Override
	public List<EmpDetailsBean> getSelectiveEmpDetailsByPanchayat(String panchayat) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		EmpDetailsBean userobj=null;			
	
		List<EmpDetailsBean> userobjs=new ArrayList<EmpDetailsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from emp_details where panchayat=?");
				ps.setString(1, panchayat);

				

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new EmpDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						userobj.setStatus(Integer.parseInt(rs.getString(10)));
						userobj.setDesignation(rs.getString(11));
						userobj.setAttendance(Integer.parseInt(rs.getString(12)));
						userobj.setSalary(Integer.parseInt(rs.getString(13)));
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}

	@Override
	public EmpDetailsBean loginCheck(String useremail, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		EmpDetailsBean userobj = null;
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from emp_details where email=? and password=?");
				ps.setString(1, useremail);
				ps.setString(2, password);

				rs = ps.executeQuery();
				if(rs.next())
					{
						userobj = new EmpDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						userobj.setStatus(Integer.parseInt(rs.getString(10)));
						userobj.setDesignation(rs.getString(11));
						userobj.setAttendance(Integer.parseInt(rs.getString(12)));
						userobj.setSalary(Integer.parseInt(rs.getString(13)));
						
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobj;
	}
	
	

	@Override
	public boolean deleteEmpDetails(String pid) {
		
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f= false;
		try
		{
			conobj=DBConnect.getMySQLConnection();
			pst=conobj.prepareStatement("delete from emp_details where pid=?");  // number of questions marks
																	// Is equal to number of tables   
			pst.setString(1,pid);


			int i=pst.executeUpdate();
			System.out.println(i);
			if(i>0)
				f=true;
		}catch(SQLException e) {
			System.out.println(e.toString());
		}
		finally {  // finally is used for closing mechanism
		try {
			if(conobj != null)
				conobj.close();
			if(pst!=null)
				pst.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		}
		return f;
	}

}
