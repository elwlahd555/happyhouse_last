package com.ssafy.happy.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.member.MemberDTO;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class LOGIN_MypageController implements Controller{
	private MemberService memberService;

	public LOGIN_MypageController() {
		memberService = new MemberServiceImpl();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO) session.getAttribute("member");
		request.setAttribute("member", memberService.searchByEmail(dto.getEmail()));
		request.getRequestDispatcher("/login/mypage.jsp").forward(request, response);
	}
}
