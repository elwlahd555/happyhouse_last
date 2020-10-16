package com.ssafy.happy.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class USER_LIstController implements Controller{
	private MemberService memberService;
	public USER_LIstController() {
		memberService = new MemberServiceImpl();
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("member", memberService.search());
		request.getRequestDispatcher("/user/userInfo.jsp").forward(request, response);
	}
}
