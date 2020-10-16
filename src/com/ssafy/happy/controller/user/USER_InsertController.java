package com.ssafy.happy.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;

public class USER_InsertController implements Controller{
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/user/userInsert.jsp").forward(request, response);
	}
}
