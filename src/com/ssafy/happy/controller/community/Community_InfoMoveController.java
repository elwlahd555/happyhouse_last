package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.community.InfoBoardService;
import com.ssafy.happy.model.service.community.InfoBoardServiceImpl;

public class Community_InfoMoveController implements Controller{
	
	private InfoBoardService infoboardService;
	
	
	public Community_InfoMoveController() {
		infoboardService = new InfoBoardServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("titleName", "공지사항");
		request.setAttribute("ActionName", "COM_INFO_INSERT");
		request.getRequestDispatcher("/community/insertPage.jsp").forward(request, response);
	}
}
