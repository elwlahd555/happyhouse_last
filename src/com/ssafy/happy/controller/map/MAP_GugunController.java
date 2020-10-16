package com.ssafy.happy.controller.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.map.GugunService;
import com.ssafy.happy.model.service.map.GugunServiceImpl;

public class MAP_GugunController implements Controller{
	
	GugunService gugunService;
	public MAP_GugunController() {
		gugunService = new GugunServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		gugunService.service(request,response);
	}
}
