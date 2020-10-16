package com.ssafy.happy.controller.apart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dao.apart.environment.EnvironmentDAO;
import com.ssafy.happy.model.dao.apart.environment.GwangJinEnvironmentDAOImpl;

public class APART_AirpullController implements Controller{
	EnvironmentDAO dao;
	public APART_AirpullController() {
		dao = new GwangJinEnvironmentDAOImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("environments", dao.getEnvironment());
		request.getRequestDispatcher("/apart/airpull.jsp").forward(request, response);
	}
}
