package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.BdoDBImpl;
import com.proj.dao.BdoDBLogic;

import com.proj.models.BdoDetailsBean;


/**
 * Servlet implementation class AdminBdoProfilesView
 */
@WebServlet("/AdminBdoProfilesView")
public class AdminBdoProfilesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBdoProfilesView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BdoDBLogic dbobj=new BdoDBImpl();
		List<BdoDetailsBean> userlist=dbobj.getAllBdoDetails();
		if(userlist.size()>0) {
			System.out.println("user prsent");
			request.setAttribute("ulist",userlist);
			RequestDispatcher rd=request.getRequestDispatcher("AdminBdoProfilesView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("errormsg","None of the BDO is Registered yet");
			RequestDispatcher rd = 
				    request.getRequestDispatcher("AdminAfterLogin.jsp");
			rd.forward(request,response);
			System.out.println("No entry in Bdo_details");
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
