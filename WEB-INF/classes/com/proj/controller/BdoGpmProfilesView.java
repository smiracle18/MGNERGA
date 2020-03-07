package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.models.GpmDetailsBean;

/**
 * Servlet implementation class BdoGpmProfilesView
 */
@WebServlet("/BdoGpmProfilesView")
public class BdoGpmProfilesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoGpmProfilesView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GpmDBLogic dbobj=new GpmDBImpl();
		List<GpmDetailsBean> userlist=dbobj.getAllGpmDetails();
		if(userlist.size()>0) {
			System.out.println("user prsent");
			request.setAttribute("ulist",userlist);
			RequestDispatcher rd=request.getRequestDispatcher("BdoGpmProfilesView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("errormsg","None of the BDO is Registered yet");
			RequestDispatcher rd = 
				    request.getRequestDispatcher("BdoAfterLogin.jsp");
			rd.forward(request,response);
			System.out.println("No entry in gpm_details");
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
