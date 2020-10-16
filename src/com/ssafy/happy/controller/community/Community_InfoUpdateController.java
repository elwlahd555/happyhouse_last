package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.community.InfoBoardDTO;
import com.ssafy.happy.model.service.community.InfoBoardService;
import com.ssafy.happy.model.service.community.InfoBoardServiceImpl;

public class Community_InfoUpdateController implements Controller{
	
	private InfoBoardService infoboardService;
	
	
	public Community_InfoUpdateController() {
		infoboardService = new InfoBoardServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int ino = Integer.parseInt(request.getParameter("key"));
//		infoboardService.delete(ino);
//		request.setAttribute("list", infoboardService.search());
		InfoBoardDTO iboard = new InfoBoardDTO();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		iboard.setTitle(title);
		iboard.setContent(content);
		iboard.setIno(ino);
		infoboardService.update(iboard);
		response.sendRedirect("main.do?action=COM_INFO_LIST");
	}
}
