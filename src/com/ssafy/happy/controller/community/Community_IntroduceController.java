package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;

public class Community_IntroduceController implements Controller{
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/community/introduce.jsp").forward(request, response);
	}
}
