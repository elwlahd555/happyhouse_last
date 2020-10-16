package com.ssafy.happy.controller.corona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.corona.ClinicService;
import com.ssafy.happy.model.service.corona.ClinicServiceImpl;
import com.ssafy.happy.model.service.corona.HospitalService;
import com.ssafy.happy.model.service.corona.HospitalServiceImpl;

public class Corona_HospitalController implements Controller{
	
	private HospitalService hospitalService;
	
	
	public Corona_HospitalController() {
		hospitalService = new HospitalServiceImpl();
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", hospitalService.search());
		request.getRequestDispatcher("/corona/hospital.jsp").forward(request, response);
	}
}
