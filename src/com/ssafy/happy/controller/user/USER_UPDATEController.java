package com.ssafy.happy.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.member.MemberDTO;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class USER_UPDATEController implements Controller{
	private MemberService memberService;

	public USER_UPDATEController() {
		memberService = new MemberServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		MemberDTO member = new MemberDTO();
		member.setEmail(request.getParameter("email"));
		
		memberService.updateByEmail(member);
		request.setAttribute("member", memberService.search());
		request.getRequestDispatcher("/user/userInfo.jsp").forward(request, response);
	}
}
