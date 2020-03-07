package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.BdoDBImpl;
import com.proj.dao.BdoDBLogic;
import com.proj.dao.BlockDBLogic;
import com.proj.dao.BlockDbImpl;
import com.proj.models.BdoDetailsBean;
import com.proj.models.BlocksBean;

/**
 * Servlet implementation class AdminBdoRegistrationRefresh
 */
@WebServlet("/AdminBdoRegistrationRefresh")
public class AdminBdoRegistrationRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBdoRegistrationRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BdoDBLogic dbBdoObj = new BdoDBImpl();
		List<BdoDetailsBean>  bdolist= dbBdoObj.getAllBdoDetails();
		
		
		BlockDBLogic dbBlockObj = new BlockDbImpl();
		List<BlocksBean> blocklist1= dbBlockObj.getAllBlocks();
		request.setAttribute("blockinfo", blocklist1);         //===========
		
		String pid="";
		String mx="B20190001";
		if (bdolist== null){
			mx="B20190000";
		}

		else{
			for(BdoDetailsBean bobj:bdolist)
			{
			if(Integer.parseInt(bobj.getPid().substring(1))>Integer.parseInt(mx.substring(1))){
				mx=bobj.getPid();
			}
			}
			
			int x= Integer.parseInt(mx.substring(1))+1;
			pid ="B"+x;
			
			request.setAttribute("pid",pid);    //================

			
		}
		
		

		RequestDispatcher rd=request.getRequestDispatcher("AdminBdoRegistration.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
