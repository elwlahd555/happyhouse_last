package com.ssafy.happy.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.member.MemberDTO;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class LOGIN_JoinController implements Controller {
	private MemberService memberService;

	public LOGIN_JoinController() {
		memberService = new MemberServiceImpl();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO member = new MemberDTO();
		member.setEmail(request.getParameter("email"));
		member.setPassword(request.getParameter("password"));
		member.setAddress(request.getParameter("address"));
		member.setName(request.getParameter("name"));
		member.setTel(request.getParameter("tel"));
		

		try {
			memberService.join(member);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}
}
