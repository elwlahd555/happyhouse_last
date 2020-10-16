package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.community.InfoBoardService;
import com.ssafy.happy.model.service.community.InfoBoardServiceImpl;

public class Community_InfoDetailController implements Controller{
	
	private InfoBoardService infoboardService;
	
	
	public Community_InfoDetailController() {
		infoboardService = new InfoBoardServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int ino = Integer.parseInt(request.getParameter("ino"));
		System.out.println(ino);
		request.setAttribute("UpdateName", "COM_INFO_UPDATE");
		request.setAttribute("ActionName", "COM_INFO_DELETE");
		request.setAttribute("titleName", "공지사항");
		request.setAttribute("board", infoboardService.showInfo(ino));
		request.getRequestDispatcher("/community/page.jsp").forward(request, response);
	}
}
