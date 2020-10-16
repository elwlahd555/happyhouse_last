package com.ssafy.happy.controller.login;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.member.MemberDTO;
import com.ssafy.happy.model.service.login.LoginService;
import com.ssafy.happy.model.service.login.LoginServiceImpl;


public class LOGIN_LoginController implements Controller{
	private LoginService loginService;
	public LOGIN_LoginController() {
		loginService =new LoginServiceImpl();
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		MemberDTO param = new MemberDTO();
		param.setEmail(email);
		param.setPassword(password);
		
		try {
			MemberDTO member = loginService.login(param);
			// 로그인 성공시 
			System.out.println(member);
			if(member != null) {
//				session 설정
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				
//				cookie 설정
				String idsave = request.getParameter("idsave");
				if("saveok".equals(idsave)) {//아이디 저장을 체크 했다면.
					Cookie cookie = new Cookie("ssafy_id", param.getEmail());
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
					response.addCookie(cookie);
				} else {//아이디 저장을 해제 했다면.
					Cookie cookies[] = request.getCookies();
					if(cookies != null) {
						for(Cookie cookie : cookies) {
							if("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "아이디 또는 패스워드가 다릅니다.");
				request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
