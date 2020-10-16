package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.community.InfoBoardService;
import com.ssafy.happy.model.service.community.InfoBoardServiceImpl;

public class Community_InfoController implements Controller{
	
	private InfoBoardService infoboardService;
	
	
	public Community_InfoController() {
		infoboardService = new InfoBoardServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", infoboardService.search());
		request.getRequestDispatcher("/community/info.jsp").forward(request, response);
	}
}
