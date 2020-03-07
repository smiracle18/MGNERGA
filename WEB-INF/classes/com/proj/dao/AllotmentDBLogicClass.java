package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.proj.models.AllotmentBean;

public class AllotmentDBLogicClass {
	
	//public boolean allotProjto(String gpm);
	public boolean allotProjto(AllotmentBean allotbeanobj) {
		
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("insert into allotment values(?,?)");  // number of questions marks
																	// Is equal to number of tables   
			
			ps.setString(1,allotbeanobj.getProjid());
			ps.setString(2,allotbeanobj.getGpmid());
					
			
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
