package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj.models.BdoDetailsBean;
import com.proj.models.ProjectsBean;



public class ProjectsDBImpl implements ProjectsDBLogic {
	
	

	@Override
	public boolean createNewProject(ProjectsBean project) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("insert into projects values(?,?,?,?,?,?,?)");  // number of questions marks
																	// Is equal to number of tables   
			
			ps.setString(1,project.getProjid());
			ps.setString(2,project.getProjname());
			
			java.sql.Date sdate=new java.sql.Date(project.getProjstartdate().getTime());
			ps.setDate(3,sdate);
			ps.setInt(4,project.getProjcapacity());
			ps.setInt(5,project.getProjstatus());
			ps.setString(6,project.getBlock());
			ps.setString(7,project.getPanchayat());

			
			
			
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
	public ProjectsBean getProjectById(String projid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ProjectsBean userobj=null;			
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from projects where projid=?");
				
				ps.setString(1,projid);


				rs = ps.executeQuery();
				if(rs.next())
				{
					userobj = new ProjectsBean();

					userobj.setProjid(rs.getString(1));
					userobj.setProjname(rs.getString(2));
					userobj.setProjstartdate(rs.getDate(3));
					userobj.setProjcapacity(Integer.parseInt(rs.getString(4)));
					userobj.setProjstatus(Integer.parseInt(rs.getString(5)));
					userobj.setBlock(rs.getString(6));
					userobj.setPanchayat(rs.getString(7));
					
				}
		}catch(SQLException e)
				{System.out.print(e.toString());}

	return userobj;	
		
		
		
		
	}

	
	
	
	@Override
	public List<ProjectsBean> getAllProjects() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ProjectsBean userobj=null;			
		List<ProjectsBean> userobjs=new ArrayList<ProjectsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from projects");

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new ProjectsBean();

						userobj.setProjid(rs.getString(1));
						userobj.setProjname(rs.getString(2));
						userobj.setProjstartdate(rs.getDate(3));
						userobj.setProjcapacity(Integer.parseInt(rs.getString(4)));
						userobj.setProjstatus(Integer.parseInt(rs.getString(5)));
						userobj.setBlock(rs.getString(6));
						userobj.setPanchayat(rs.getString(7));
						
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;	
	}



	@Override
	public List<ProjectsBean> getProjectsOfBlock(String block) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ProjectsBean userobj=null;			
		List<ProjectsBean> userobjs=new ArrayList<ProjectsBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from projects where block=?");
				
				ps.setString(1, block);

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new ProjectsBean();

						userobj.setProjid(rs.getString(1));
						userobj.setProjname(rs.getString(2));
						userobj.setProjstartdate(rs.getDate(3));
						userobj.setProjcapacity(Integer.parseInt(rs.getString(4)));
						userobj.setProjstatus(Integer.parseInt(rs.getString(5)));
						userobj.setBlock(rs.getString(6));
						userobj.setPanchayat(rs.getString(7));
						
						
						
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;	
	}



	@Override
	public boolean deleteProject(String projid) {
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f= false;
		try
		{
			conobj=DBConnect.getMySQLConnection();
			pst=conobj.prepareStatement("delete from projects where projid=?");  // number of questions marks
																	// Is equal to number of tables   
			pst.setString(1,projid);


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
	public boolean updateStatus(String projid) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("update projects set projstatus=1 where projid=?");  // number of questions marks
																	// Is equal to number of tables   
			
			
			ps.setString(1,projid);
			
			
			
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
