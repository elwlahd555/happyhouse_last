package com.ssafy.happy.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;

public class LOGIN_InterestplaceController implements Controller {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login/interestplace.jsp").forward(request, response);
	}

}
