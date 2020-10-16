package com.ssafy.happy.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.common.ActionHandlerMapping;



@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ActionHandlerMapping ahm = new ActionHandlerMapping();
	public void init(ServletConfig config) {}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("PJT04 도착!");
		String action = request.getParameter("action");
		if (action == null) {
			action="MAIN";
		} 
		System.out.println(action);
		try {
	
			Controller control = ahm.getController(action);
			if(control != null) control.service(request,response); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}
}
