package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.BlockDBLogic;
import com.proj.dao.BlockDbImpl;
import com.proj.dao.PanchayatDBImpl;
import com.proj.dao.PanchayatsDBLogic;
import com.proj.models.BdoDetailsBean;
import com.proj.models.BlocksBean;
import com.proj.models.PanchayatsBean;

/**
 * Servlet implementation class BdoAddNewPanchayats
 */
@WebServlet("/BdoAddNewPanchayats")
public class BdoAddNewPanchayats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoAddNewPanchayats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		


		
		PanchayatsBean panchayat=new PanchayatsBean();  // create object of model class

		panchayat.setPname(request.getParameter("pname"));
		panchayat.setBname(request.getParameter("bname"));
		panchayat.setPsize(Integer.parseInt(request.getParameter("psize")));
		
		
		
		PanchayatsDBLogic panchayatObj=new PanchayatDBImpl();
		boolean b= panchayatObj.insertPanchayat(panchayat);
		if(b)
		{
			System.out.println("record inserted");
			
			request.setAttribute("recordinserted", "PANCHAYAT REGISTERED");
			RequestDispatcher rd=request.getRequestDispatcher("BdoAddNewPanchayatsRefresh");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("record not inserted");
			request.setAttribute("recordnotinserted", "PANCHAYAT NOT REGISTERED");
			RequestDispatcher rd=request.getRequestDispatcher("BdoAddNewPanchayatsRefresh");
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
