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
 * Servlet implementation class AdminRequestDeleteBdo
 */
@WebServlet("/AdminRequestDeleteBdo")
public class AdminRequestDeleteBdo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRequestDeleteBdo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pid=request.getParameter("pid");
		BdoDBLogic dbobj=new BdoDBImpl();
		boolean k=dbobj.deleteBdoDetails(pid);
		if(k) {
			RequestDispatcher rd=request.getRequestDispatcher("AdminBdoProfilesView");
			rd.forward(request, response);
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
