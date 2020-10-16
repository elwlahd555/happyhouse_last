package com.ssafy.happy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainController implements Controller{
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
}
