package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.community.QBoardService;
import com.ssafy.happy.model.service.community.QBoardServiceImpl;

public class Community_QandAListAController implements Controller{
	private QBoardService qboardService;
	
	
	
	public Community_QandAListAController() {
		qboardService = new QBoardServiceImpl();
	}



	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", qboardService.search());
		request.getRequestDispatcher("/community/qa.jsp").forward(request, response);
	}
}
