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

import com.proj.dao.BdoDBImpl;
import com.proj.dao.BdoDBLogic;
import com.proj.dao.BlockDBLogic;
import com.proj.dao.BlockDbImpl;
import com.proj.models.BdoDetailsBean;
import com.proj.models.BlocksBean;

/**
 * Servlet implementation class AddBlock
 */
@WebServlet("/AddBlock")
public class AddBlock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		BlocksBean block=new BlocksBean();  // create object of model class

		block.setBname(request.getParameter("bname"));
		block.setBsize(Integer.parseInt(request.getParameter("bsize")));
		
		
		
		BlockDBLogic blockObj=new BlockDbImpl();
		boolean b= blockObj.insertBlock(block);
		if(b)
		{
			System.out.println("record inserted");
			
			request.setAttribute("recordinserted", "BLOCK REGISTERED");
			RequestDispatcher rd=request.getRequestDispatcher("AdminAddNewBlock.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("record not inserted");
			request.setAttribute("recordnotinserted", "BLOCK NOT REGISTERED");
			RequestDispatcher rd=request.getRequestDispatcher("AdminAddNewBlock.jsp");
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
