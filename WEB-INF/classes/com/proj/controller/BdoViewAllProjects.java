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

import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.dao.PanchayatDBImpl;
import com.proj.dao.PanchayatsDBLogic;
import com.proj.dao.ProjectsDBImpl;
import com.proj.dao.ProjectsDBLogic;
import com.proj.models.BdoDetailsBean;
import com.proj.models.GpmDetailsBean;
import com.proj.models.PanchayatsBean;
import com.proj.models.ProjectsBean;

/**
 * Servlet implementation class BdoViewAllProjects
 */
@WebServlet("/BdoViewAllProjects")
public class BdoViewAllProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoViewAllProjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		
		BdoDetailsBean bdo=(BdoDetailsBean)session.getAttribute("bdoinfo");
		String bdoname=bdo.getName();
		String block=bdo.getBlock();

		
		ProjectsDBLogic proj=new ProjectsDBImpl();
		List<ProjectsBean> projectsFromCurrentBlock=proj.getProjectsOfBlock(block);
		
		request.setAttribute("projectsFromCurrentBlock", projectsFromCurrentBlock);
		
		
		
		request.setAttribute("bdoname",bdoname);
		request.setAttribute("block",block);

		
		

		RequestDispatcher rd=request.getRequestDispatcher("BdoViewAllProjects.jsp");
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
