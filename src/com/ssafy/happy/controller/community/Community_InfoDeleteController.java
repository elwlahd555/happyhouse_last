package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.community.InfoBoardService;
import com.ssafy.happy.model.service.community.InfoBoardServiceImpl;

public class Community_InfoDeleteController implements Controller{
	
	private InfoBoardService infoboardService;
	
	
	public Community_InfoDeleteController() {
		infoboardService = new InfoBoardServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int ino = Integer.parseInt(request.getParameter("ino"));
		System.out.println(ino);
		infoboardService.delete(ino);
//		request.setAttribute("list", infoboardService.search());
		response.sendRedirect("main.do?action=COM_INFO_LIST");
	}
}
