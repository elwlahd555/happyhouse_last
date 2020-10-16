package com.ssafy.happy.controller.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.member.MemberDTO;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class LOGIN_UpdateController implements Controller {
	private MemberService memberService;

	public LOGIN_UpdateController() {
		memberService = new MemberServiceImpl();
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO member = new MemberDTO();
		HttpSession session = request.getSession();
		MemberDTO dto=(MemberDTO) session.getAttribute("member");
		member.setEmail(dto.getEmail());
		member.setPassword(request.getParameter("password"));
		member.setAddress(request.getParameter("address"));
		member.setName(request.getParameter("name"));
		member.setTel(request.getParameter("tel"));
		

		try {
			memberService.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

}
