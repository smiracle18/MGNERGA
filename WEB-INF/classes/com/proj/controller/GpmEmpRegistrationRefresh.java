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

import com.proj.dao.EmpDBImpl;
import com.proj.dao.EmpDBLogic;
import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.dao.PanchayatDBImpl;
import com.proj.dao.PanchayatsDBLogic;
import com.proj.models.BdoDetailsBean;
import com.proj.models.EmpDetailsBean;
import com.proj.models.GpmDetailsBean;
import com.proj.models.PanchayatsBean;

/**
 * Servlet implementation class GpmEmpRegistrationRefresh
 */
@WebServlet("/GpmEmpRegistrationRefresh")
public class GpmEmpRegistrationRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GpmEmpRegistrationRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String pid=null;
		
		
		
		

		EmpDBLogic dbBdoObj1 = new EmpDBImpl();
		List<EmpDetailsBean>  gpmlist = dbBdoObj1.getAllEmpDetails();
		
		
		
		String mx="E20190001";
		if (gpmlist== null){
			mx="E20190000";
		}

		else{
			for(EmpDetailsBean bobj:gpmlist)
			{
			if(Integer.parseInt(bobj.getPid().substring(1))>Integer.parseInt(mx.substring(1))){
				mx=bobj.getPid();
			}
			}
			
			int x= Integer.parseInt(mx.substring(1))+1;
			pid ="E"+x;
		}
		
		
		request.setAttribute("pid",pid);
		

		
		

		RequestDispatcher rd=request.getRequestDispatcher("GpmEmpRegistration.jsp");
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
