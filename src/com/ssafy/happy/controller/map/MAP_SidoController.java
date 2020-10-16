package com.ssafy.happy.controller.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.map.SidoService;
import com.ssafy.happy.model.service.map.SidoServiceImpl;

public class MAP_SidoController implements Controller{
	
	SidoService sidoService;
	public MAP_SidoController() {
		sidoService = new SidoServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		sidoService.service(request,response);
		
	}
}
