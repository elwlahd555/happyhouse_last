package com.ssafy.happy.controller.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.map.DongService;
import com.ssafy.happy.model.service.map.DongServiceImpl;

public class MAP_DongController implements Controller{
	
	DongService dongService;
	public MAP_DongController() {
		dongService = new DongServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		dongService.service(request,response);
		
	}
}
