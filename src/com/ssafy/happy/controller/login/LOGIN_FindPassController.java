package com.ssafy.happy.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;

public class LOGIN_FindPassController implements Controller{
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/login/password.jsp").forward(request, response);
	}
}
