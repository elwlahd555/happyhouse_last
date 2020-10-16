package com.ssafy.happy.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dao.apart.environment.EnvironmentDAO;
import com.ssafy.happy.model.dao.apart.environment.GwangJinEnvironmentDAOImpl;

public class USER_InterestController implements Controller{
	
	public USER_InterestController() {
	
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.getRequestDispatcher("/user/interestPlace.jsp").forward(request, response);
	}
}
