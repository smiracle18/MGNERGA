package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj.models.BdoDetailsBean;
import com.proj.models.GpmDetailsBean;

public class BdoDBImpl implements BdoDBLogic {

	
	
		@Override
		public boolean insertBdo(BdoDetailsBean bdoobj) {
			
			Connection conn=null;
			PreparedStatement ps=null;
			boolean f= false;
			
			
			try
			{
				conn=DBConnect.getMySQLConnection();
				ps=conn.prepareStatement("insert into bdo_details values(?,?,?,?,?,?,?,?,?)");  // number of questions marks
																		// Is equal to number of tables   
				
				ps.setString(1,bdoobj.getPid());
				ps.setString(2,bdoobj.getName());
				ps.setString(3,bdoobj.getEmail());
				ps.setString(4,bdoobj.getPassword());
				java.sql.Date sdate=new java.sql.Date(bdoobj.getDob().getTime());
				ps.setDate(5,sdate);
				ps.setString(6,bdoobj.getSex());
				ps.setString(7,bdoobj.getBlock());
				ps.setString(8, bdoobj.getPhoneno());
				ps.setInt(9,0);
				
				
				
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
		public BdoDetailsBean loginCheck(String useremail, String password) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			BdoDetailsBean userobj = null;
			try
				{
					conn = DBConnect.getMySQLConnection();

					ps = conn.prepareStatement("select * from bdo_details where email=? and password=?");
					ps.setString(1, useremail);
					ps.setString(2, password);

					rs = ps.executeQuery();
					if(rs.next())
						{
							userobj = new BdoDetailsBean();
							
							userobj.setPid(rs.getString(1));
							userobj.setName(rs.getString(2));
							userobj.setEmail(rs.getString(3));
							userobj.setPassword(rs.getString(4));
							userobj.setDob(rs.getDate(5));
							userobj.setSex(rs.getString(6));
							userobj.setBlock(rs.getString(7));
							userobj.setPhoneno(rs.getString(8));
							
						}
				}catch(SQLException e)
						{System.out.print(e.toString());}

			return userobj;

			
		}
		
		
		
		

		@Override
		public List<BdoDetailsBean> getAllBdoDetails() {
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			BdoDetailsBean userobj=null;			
			List<BdoDetailsBean> userobjs=new ArrayList<BdoDetailsBean>();
			
			try
				{
					conn = DBConnect.getMySQLConnection();

					ps = conn.prepareStatement("select * from bdo_details");

					rs = ps.executeQuery();
					while(rs.next())
						{
							userobj = new BdoDetailsBean();

							userobj.setPid(rs.getString(1));
							userobj.setName(rs.getString(2));
							userobj.setEmail(rs.getString(3));
							userobj.setPassword(rs.getString(4));
							userobj.setDob(rs.getDate(5));
							userobj.setSex(rs.getString(6));
							userobj.setBlock(rs.getString(7));
							userobj.setPhoneno(rs.getString(8));
							
							
							userobjs.add(userobj);
						}
				}catch(SQLException e)
						{System.out.print(e.toString());}

			return userobjs;		
		}



		@Override
		public boolean deleteBdoDetails(String pid) {
			Connection conobj=null;
			PreparedStatement pst=null;
			boolean f= false;
			try
			{
				conobj=DBConnect.getMySQLConnection();
				pst=conobj.prepareStatement("delete from bdo_details where pid=?");  // number of questions marks
																		// Is equal to number of tables   
				pst.setString(1,pid);


				int i=pst.executeUpdate();
				System.out.println(i);
				if(i>0)
					f=true;
			}catch(SQLException e) {
				System.out.println(e.toString());
			}
			finally {  // finally is used for clossing mechanism
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
		public BdoDetailsBean getBdoDetailsOf(String pid) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			BdoDetailsBean userobj=null;			
			
			try
				{
					conn = DBConnect.getMySQLConnection();

					ps = conn.prepareStatement("select * from bdo_details where pid=?");
					
					ps.setString(1,pid);


					rs = ps.executeQuery();
					if(rs.next())
					{
						userobj = new BdoDetailsBean();

						userobj.setPid(rs.getString(1));
						userobj.setName(rs.getString(2));
						userobj.setEmail(rs.getString(3));
						userobj.setPassword(rs.getString(4));
						userobj.setDob(rs.getDate(5));
						userobj.setSex(rs.getString(6));
						userobj.setBlock(rs.getString(7));
						userobj.setPhoneno(rs.getString(8));
						
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobj;	
			
			
		}
		
		
		
		
		

}
