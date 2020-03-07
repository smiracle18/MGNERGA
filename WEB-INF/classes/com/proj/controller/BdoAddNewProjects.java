package com.proj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.PanchayatDBImpl;
import com.proj.dao.PanchayatsDBLogic;
import com.proj.dao.ProjectsDBImpl;
import com.proj.dao.ProjectsDBLogic;
import com.proj.models.PanchayatsBean;
import com.proj.models.ProjectsBean;

/**
 * Servlet implementation class BdoAddNewProjects
 */
@WebServlet("/BdoAddNewProjects")
public class BdoAddNewProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoAddNewProjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		ProjectsBean project=new ProjectsBean();  // create object of model class

		
		
		
		project.setProjid(request.getParameter("pid"));
		project.setProjname(request.getParameter("projname"));
		
		String projstartdate=request.getParameter("projstartdate");
		try {
			Date startdate=sdf.parse(projstartdate);
			project.setProjstartdate(startdate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		project.setBlock(request.getParameter("bname"));
		project.setPanchayat(request.getParameter("pname"));
		project.setProjcapacity(Integer.parseInt(request.getParameter("projcapacity")));
		
		
		ProjectsDBLogic projobj=new ProjectsDBImpl();
		boolean b= projobj.createNewProject(project);
		if(b)
		{
			System.out.println("project created");
			
			request.setAttribute("recordinserted", "PROJECT CREATED");
			RequestDispatcher rd=request.getRequestDispatcher("BdoAddNewProjectsRefresh");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("project not created");
			request.setAttribute("recordnotinserted", "PROJECT NOT CREATED READ INSTRUCTIONS");
			RequestDispatcher rd=request.getRequestDispatcher("BdoAddNewProjectsRefresh");
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
