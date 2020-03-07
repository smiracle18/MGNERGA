package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj.models.BlocksBean;




public class BlockDbImpl implements BlockDBLogic{

	@Override
	public List<BlocksBean> getAllBlocks() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BlocksBean userobj=null;			
		List<BlocksBean> userobjs=new ArrayList<BlocksBean>();
		
		try
			{
				conn = DBConnect.getMySQLConnection();

				ps = conn.prepareStatement("select * from blocks");

				rs = ps.executeQuery();
				while(rs.next())
					{
						userobj = new BlocksBean();

						userobj.setBname(rs.getString(1));
						userobj.setBsize(Integer.parseInt(rs.getString(2)));
											
						
						userobjs.add(userobj);
					}
			}catch(SQLException e)
					{System.out.print(e.toString());}

		return userobjs;		
	}
	
	

	@Override
	public boolean insertBlock(BlocksBean block) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean f= false;
		
		
		try
		{
			conn=DBConnect.getMySQLConnection();
			ps=conn.prepareStatement("insert into blocks values(?,?)");  // number of questions marks
																	// Is equal to number of tables   
			
			ps.setString(1,block.getBname());
			ps.setInt(2,block.getBsize());
			
			
			
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


