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
import com.proj.dao.GpmDBImpl;
import com.proj.dao.GpmDBLogic;
import com.proj.dao.PanchayatDBImpl;
import com.proj.dao.PanchayatsDBLogic;
import com.proj.models.BdoDetailsBean;
import com.proj.models.GpmDetailsBean;
import com.proj.models.PanchayatsBean;

/**
 * Servlet implementation class BdoGpmRegistrationRefresh
 */
@WebServlet("/BdoGpmRegistrationRefresh")
public class BdoGpmRegistrationRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BdoGpmRegistrationRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String pid=null;
		
		BdoDetailsBean bn=(BdoDetailsBean)session.getAttribute("bdoinfo");
		System.out.println(bn);
		
		BdoDetailsBean bdo=(BdoDetailsBean)session.getAttribute("bdoinfo");
		String bdoname=bdo.getName();
		String block=bdo.getBlock();

		GpmDBLogic dbBdoObj1 = new GpmDBImpl();
		List<GpmDetailsBean>  gpmlist = dbBdoObj1.getAllGpmDetails();
		
		PanchayatsDBLogic doPanc=new PanchayatDBImpl();
		List<PanchayatsBean> panchayatlist1=doPanc.getPanchayatsOfBlock(block);
		request.setAttribute("panchayatsInCurrentBlock", panchayatlist1);
		
		
		String mx="G20190001";
		if (gpmlist== null){
			mx="G20190000";
		}

		else{
			for(GpmDetailsBean bobj:gpmlist)
			{
			if(Integer.parseInt(bobj.getPid().substring(1))>Integer.parseInt(mx.substring(1))){
				mx=bobj.getPid();
			}
			}
			
			int x= Integer.parseInt(mx.substring(1))+1;
			pid ="G"+x;
		}
		
		request.setAttribute("recordnotinserted", request.getAttribute("recordnotinserted"));
		request.setAttribute("recordinserted", request.getAttribute("recordinserted"));
		request.setAttribute("pid",pid);
		request.setAttribute("bdoname",bdoname);
		request.setAttribute("block",block);

		
		

		RequestDispatcher rd=request.getRequestDispatcher("BdoGpmRegistration.jsp");
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
