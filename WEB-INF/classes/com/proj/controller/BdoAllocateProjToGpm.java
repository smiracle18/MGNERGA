package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.AllotmentDBLogicClass;
import com.proj.dao.BdoDBImpl;
import com.proj.dao.BdoDBLogic;
import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.dao.ProjectsDBImpl;
import com.proj.dao.ProjectsDBLogic;
import com.proj.models.AllotmentBean;
import com.proj.models.BdoDetailsBean;

/**
 * Servlet implementation class BdoAllocateProjToGpm
 */
@WebServlet("/BdoAllocateProjToGpm")
public class BdoAllocateProjToGpm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoAllocateProjToGpm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AllotmentBean allotobj=new AllotmentBean();
		
		String a=request.getParameter("projid");
		String bb=request.getParameter("gpmid");


		allotobj.setProjid(a);
		allotobj.setGpmid(bb);
		
		System.out.println(allotobj);
		
		
		AllotmentDBLogicClass allodb=new AllotmentDBLogicClass();
		
		boolean b= allodb.allotProjto(allotobj);
		if(b)
		{
			System.out.println("record inserted");
			GpmDBLogic gpmdb =new GpmDBImpl();
			gpmdb.updateStatus(bb);
			
			ProjectsDBLogic projdb=new ProjectsDBImpl();
			projdb.updateStatus(a);
			
			
			
			request.setAttribute("recordinserted", "Successfully Alloted");
			RequestDispatcher rd=request.getRequestDispatcher("BdoViewAllProjects");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("record not inserted");
			request.setAttribute("recordnotinserted", "Not Alloted");
			RequestDispatcher rd=request.getRequestDispatcher("BdoViewAllProjects");
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
