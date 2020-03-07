package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.models.BdoDetailsBean;

/**
 * Servlet implementation class BdoAddNewPanchayatsRefresh
 */
@WebServlet("/BdoAddNewPanchayatsRefresh")
public class BdoAddNewPanchayatsRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoAddNewPanchayatsRefresh() {
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
		
		request.setAttribute("block", block);
		request.setAttribute("bdoname", bdoname);
		
		RequestDispatcher rd=request.getRequestDispatcher("BdoAddNewPanchayats.jsp");
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
