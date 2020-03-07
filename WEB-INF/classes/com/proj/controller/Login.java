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

import com.proj.dao.BdoDBImpl;
import com.proj.dao.BdoDBLogic;
import com.proj.dao.BlockDBLogic;
import com.proj.dao.BlockDbImpl;
import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.dao.PanchayatDBImpl;
import com.proj.dao.PanchayatsDBLogic;
import com.proj.dao.ProjectsDBImpl;
import com.proj.dao.ProjectsDBLogic;
import com.proj.models.BdoDetailsBean;
import com.proj.models.BlocksBean;
import com.proj.models.GpmDetailsBean;
import com.proj.models.PanchayatsBean;
import com.proj.models.ProjectsBean;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println(request.getParameter("usertype"));
		
		
		
		
		
		if(request.getParameter("usertype").equals("BDO"))
		{
			String userid = request.getParameter("useremail");
			String password = request.getParameter("userpass");
			
			
					if(userid.equals("admin@admin.com")&&password.equals("admin"))
					{
	
						
						response.sendRedirect("AdminAfterLogin.jsp");	

			
					}
					else     //creating session for BDO
					{
						
						
					BdoDBLogic dbBdoObj = new BdoDBImpl();
					BdoDetailsBean  bdoObj= dbBdoObj.loginCheck(userid, password);
					
					BdoDetailsBean bdoObj1= bdoObj;  //for user info
					
					String currentBlock= bdoObj.getBlock();
					

					

					
					
					
					if(bdoObj1 != null)
					{
						System.out.println("WELCOME USER");
						
				    HttpSession session = request.getSession(true);     //keeping BDO into session
					session.setAttribute("bdoinfo", bdoObj);
					session.setAttribute("currentBlock", currentBlock);

					    
						response.sendRedirect("BdoAfterLoginPage.jsp");	
					}
					else
					{
						System.out.println("INVALID UID OR PASS");
						
						request.setAttribute("errormsg", "INVALID UID OR PASS");
						
						RequestDispatcher rd = 
							    request.getRequestDispatcher("Login.jsp");
						if(rd != null)
						  rd.forward(request, response);
						else
							System.out.println("Wrong File Name");
					}
			}
		}
		
		
		//------------------------------------------------
		
		else //for gpm as usertype
		{
			
			
			String userid = request.getParameter("useremail");
			String password = request.getParameter("userpass");	
			
			
			
			if(userid.equals("admin@admin.com")&&password.equals("admin"))
			{
				
				
				response.sendRedirect("AdminAfterLogin.jsp");	

				
			}
			
			else
			{
			GpmDBLogic dbGpmObj = new GpmDBImpl();
			GpmDetailsBean gpmObj = dbGpmObj.loginCheck(userid, password);
			
			if(gpmObj != null)
			{
				System.out.println("WELCOME USER");
				
		    HttpSession session = request.getSession(true);
				session.setAttribute("gpminfo", gpmObj);
			    response.sendRedirect("GpmAfterLoginPage.jsp");	
			}
			else
			{
				System.out.println("INVALID UID OR PASS");
				
				request.setAttribute("errormsg", "INVALID UID OR PASS");
				
				RequestDispatcher rd = 
					    request.getRequestDispatcher("Login.jsp");
				if(rd != null)
				  rd.forward(request, response);
				else
					System.out.println("Wrong File Name");
			}
			}
		
		
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
