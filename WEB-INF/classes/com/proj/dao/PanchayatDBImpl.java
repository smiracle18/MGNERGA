package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj.models.PanchayatsBean;



public class PanchayatDBImpl implements PanchayatsDBLogic {
	
	

	@Override
	public List<PanchayatsBean> getAllPanchayats() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PanchayatsBean userobj=null;			
		List<PanchayatsBean> userobjs=new ArrayList<PanchayatsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from panchayats");

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new PanchayatsBean();

						userobj.setPname(rs.getString(1));
						userobj.setBname(rs.getString(2));
						userobj.setPsize(Integer.parseInt(rs.getString(3)));
											
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}
	
	
	
	
	
	

	@Override
	public boolean insertPanchayat(PanchayatsBean panchayat) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("insert into panchayats values(?,?,?)");  // number of questions marks
																	// Is equal to number of tables   
			
			ps.setString(1,panchayat.getPname());
			ps.setString(2,panchayat.getBname());
			ps.setInt(3,panchayat.getPsize());
			
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
	public List<PanchayatsBean> getPanchayatsOfBlock(String block) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PanchayatsBean userobj=null;			
		List<PanchayatsBean> userobjs=new ArrayList<PanchayatsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from panchayats where bname=?");
				ps.setString(1, block);

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new PanchayatsBean();

						userobj.setPname(rs.getString(1));
						userobj.setBname(rs.getString(2));
						userobj.setPsize(Integer.parseInt(rs.getString(3)));
											
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;
	}
	
	

}
