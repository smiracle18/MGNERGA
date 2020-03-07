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
import com.proj.dao.ProjectsDBImpl;
import com.proj.dao.ProjectsDBLogic;
import com.proj.models.GpmDetailsBean;
import com.proj.models.ProjectsBean;

/**
 * Servlet implementation class BdoAllocateProjectsGpm
 */
@WebServlet("/BdoAllocateProjectsGpm")
public class BdoAllocateProjectsGpm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoAllocateProjectsGpm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GpmDBLogic gpmdb=new GpmDBImpl();
		List<GpmDetailsBean> gpmlistNotAssignedYet=gpmdb.getSelectiveGpmDetailsByStatus();
		
		request.setAttribute("gpmlistNotAssignedYet", gpmlistNotAssignedYet);
		
		
		String projid=request.getParameter("projid");
		
		request.setAttribute("projid", projid);
		
		
	
		ProjectsDBLogic projdb= new ProjectsDBImpl();
		ProjectsBean projobj=projdb.getProjectById(projid);
		
		String projname=projobj.getProjname();
		
		request.setAttribute("projname", projname);
		request.setAttribute("recordinserted", null);
		request.setAttribute("recordnotinserted", null);


		
	
			RequestDispatcher rd=request.getRequestDispatcher("BdoAllocateProjectsGpm.jsp");
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
