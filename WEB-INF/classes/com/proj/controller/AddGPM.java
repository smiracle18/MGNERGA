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


import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.models.GpmDetailsBean;

/**
 * Servlet implementation class AddGPM
 */
@WebServlet("/AddGPM")
public class AddGPM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGPM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		GpmDetailsBean person=new GpmDetailsBean();  // create object of model class
		
		person.setPid(request.getParameter("pid"));
		person.setName(request.getParameter("name"));
		person.setEmail(request.getParameter("email"));
		person.setPassword(request.getParameter("password"));
		
		
		String dobstr=request.getParameter("dob");
		try {
			Date dob=sdf.parse(dobstr);
			person.setDob(dob);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		person.setSex(request.getParameter("sex"));
		person.setBlock(request.getParameter("block"));
		person.setBlock(request.getParameter("panchayat"));

		person.setPhoneno(request.getParameter("phoneno"));
		System.out.println(person);
		
		GpmDBLogic gpmObj=new GpmDBImpl();
		boolean b= gpmObj.addNewGpm(person);
		if(b)
		{
			System.out.println("record inserted");
			
			request.setAttribute("recordinserted", "GPM REGISTERED");
			RequestDispatcher rd=request.getRequestDispatcher("BdoGpmRegistrationRefresh");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("record not inserted");
			request.setAttribute("recordnotinserted", "GPM NOT REGISTERED");
			RequestDispatcher rd=request.getRequestDispatcher("BdoGpmRegistrationRefresh");
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
