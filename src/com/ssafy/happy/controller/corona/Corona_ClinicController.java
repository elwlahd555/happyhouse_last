package com.ssafy.happy.controller.corona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.corona.ClinicService;
import com.ssafy.happy.model.service.corona.ClinicServiceImpl;

public class Corona_ClinicController implements Controller{
	
	private ClinicService clinicService;
	
	
	public Corona_ClinicController() {
		 clinicService = new ClinicServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", clinicService.search());
		request.getRequestDispatcher("/corona/clinic.jsp").forward(request, response);
	}
}
