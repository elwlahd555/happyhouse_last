package com.ssafy.happy.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;

public class LOGIN_RegisterController implements Controller{
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/login/register.jsp").forward(request, response);
	}
}
