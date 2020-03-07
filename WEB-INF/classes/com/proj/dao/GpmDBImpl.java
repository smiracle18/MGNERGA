package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.proj.models.GpmDetailsBean;



public class GpmDBImpl implements GpmDBLogic{

	
	
	
	
	@Override
	public List<GpmDetailsBean> getAllGpmDetails() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		GpmDetailsBean userobj=null;			
		List<GpmDetailsBean> userobjs=new ArrayList<GpmDetailsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from gpm_details");

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new GpmDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;	
	}
	
	
	
	

	@Override
	public boolean addNewGpm(GpmDetailsBean gpmobj) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("insert into gpm_details values(?,?,?,?,?,?,?,?,?,?)");  // number of questions marks
																							// Is equal to number of tables   
			
			ps.setString(1,gpmobj.getPid());
			ps.setString(2,gpmobj.getName());
			ps.setString(3,gpmobj.getEmail());
			ps.setString(4,gpmobj.getPassword());
			
			java.sql.Date sdate=new java.sql.Date(gpmobj.getDob().getTime());
			ps.setDate(5,sdate);
			
			ps.setString(6,gpmobj.getSex());
			ps.setString(7,gpmobj.getBlock());
			ps.setString(8,gpmobj.getPanchayat());
			ps.setString(9, gpmobj.getPhoneno());
			ps.setInt(10,0);
			
			
			
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
	public GpmDetailsBean loginCheck(String useremail, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		GpmDetailsBean userobj = null;
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from gpm_details where email=? and password=?");
				ps.setString(1, useremail);
				ps.setString(2, password);

				rs = ps.executeQuery();
				if(rs.next())
					{
						userobj = new GpmDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						
						
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobj;
	}





	@Override
	public List<GpmDetailsBean> getSelectiveGpmDetailsByBlock(String block) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		GpmDetailsBean userobj=null;			
		List<GpmDetailsBean> userobjs=new ArrayList<GpmDetailsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from gpm_details where block=?");
				ps.setString(1, block);

				

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new GpmDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}





	@Override
	public boolean deleteGpmDetails(String pid) {
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f= false;
		try
		{
			conobj=DBConnect.getMySQLConnection();
			pst=conobj.prepareStatement("delete from gpm_details where pid=?");  // number of questions marks
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





	@Override
	public List<GpmDetailsBean> getSelectiveGpmDetailsByStatus() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		GpmDetailsBean userobj=null;			
		List<GpmDetailsBean> userobjs=new ArrayList<GpmDetailsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from gpm_details where status=0");

				

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new GpmDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPanchayat(rs.getString(8));
						userobj.setPhoneno(rs.getString(9));
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}





	@Override
	public boolean updateStatus(String pid) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("update gpm_details set status=1 where pid=?");  // number of questions marks
																							// Is equal to number of tables   
			ps.setString(1, pid);
			
			
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

}
