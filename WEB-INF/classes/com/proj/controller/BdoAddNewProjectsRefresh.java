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
 * Servlet implementation class BdoAddNewProjectsRefresh
 */
@WebServlet("/BdoAddNewProjectsRefresh")
public class BdoAddNewProjectsRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoAddNewProjectsRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String pid=null;
		
		
		BdoDetailsBean bdo=(BdoDetailsBean)session.getAttribute("bdoinfo");
		String bdoname=bdo.getName();
		String block=bdo.getBlock();

		
		PanchayatsDBLogic doPanc=new PanchayatDBImpl();
		List<PanchayatsBean> panchayatlist1=doPanc.getPanchayatsOfBlock(block);
		request.setAttribute("panchayatsInCurrentBlock", panchayatlist1);
		
		ProjectsDBLogic proj=new ProjectsDBImpl();
		List<ProjectsBean> projlist=proj.getAllProjects();
		String mx="P20190001";
		if (projlist== null){
			mx="P20190000";
		}

		else{
			for(ProjectsBean bobj:projlist)
			{
			if(Integer.parseInt(bobj.getProjid().substring(1))>Integer.parseInt(mx.substring(1))){
				mx=bobj.getProjid();
			}
			}
			
			int x= Integer.parseInt(mx.substring(1))+1;
			pid ="P"+x;
			
		}
		
		
		request.setAttribute("pid",pid);
		request.setAttribute("bdoname",bdoname);
		request.setAttribute("block",block);

		
		

		RequestDispatcher rd=request.getRequestDispatcher("BdoAddNewProjects.jsp");
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
