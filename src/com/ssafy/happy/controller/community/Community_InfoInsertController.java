package com.ssafy.happy.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.community.InfoBoardDTO;
import com.ssafy.happy.model.service.community.InfoBoardService;
import com.ssafy.happy.model.service.community.InfoBoardServiceImpl;

public class Community_InfoInsertController implements Controller{
	
	private InfoBoardService infoboardService;
	
	
	public Community_InfoInsertController() {
		infoboardService = new InfoBoardServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		infoboardService.delete(ino);
//		request.setAttribute("list", infoboardService.search());
		InfoBoardDTO iboard = new InfoBoardDTO();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String position = request.getParameter("position");
		String wday = request.getParameter("wday");
//		iboard.setTitle(title);
//		iboard.setContent(content);
	
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(wday);
		iboard.setTitle(title);
		iboard.setContent(content);
		iboard.setWriter(writer);
		iboard.setWday(wday);
		iboard.setPosition(position);
		infoboardService.add(iboard);
		response.sendRedirect("main.do?action=COM_INFO_LIST");
	}
}
