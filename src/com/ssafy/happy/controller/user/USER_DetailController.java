package com.ssafy.happy.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class USER_DetailController implements Controller{
	private MemberService memberService;

	public USER_DetailController() {
		memberService = new MemberServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("user", memberService.searchByEmail(request.getParameter("email")));
		request.getRequestDispatcher("/user/userDetail.jsp").forward(request, response);
	}
}
