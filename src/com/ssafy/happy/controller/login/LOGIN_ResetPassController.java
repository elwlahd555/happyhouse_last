package com.ssafy.happy.controller.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.member.MemberDTO;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class LOGIN_ResetPassController implements Controller{
	private MemberService memberService;

	public LOGIN_ResetPassController() {
		memberService = new MemberServiceImpl();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		String email=request.getParameter("email");
		System.out.println(email);
		
		try {
			MemberDTO member = memberService.searchByEmail(email);
			// 로그인 성공시 
			if (member.getEmail().equals(email)) {
				member.setPassword("0000");
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				memberService.update(member);
				request.getRequestDispatcher("/login/resetResult.jsp").forward(request, response);
			} 
			// 로그인 실패시
			else {
				request.setAttribute("msg", "아이디 또는 패스워드가 다릅니다.");
				request.getRequestDispatcher("/login/password.jsp").forward(request, response);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
