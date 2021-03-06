package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.EmpDBImpl;
import com.proj.dao.EmpDBLogic;
import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;

/**
 * Servlet implementation class GpmRequestDeleteEmp
 */
@WebServlet("/GpmRequestDeleteEmp")
public class GpmRequestDeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GpmRequestDeleteEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		EmpDBLogic dbobj=new EmpDBImpl();
		boolean k=dbobj.deleteEmpDetails(pid);
		if(k) {
			RequestDispatcher rd=request.getRequestDispatcher("GpmEmpProfilesView");
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
