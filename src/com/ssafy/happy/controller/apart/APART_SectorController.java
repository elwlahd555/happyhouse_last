package com.ssafy.happy.controller.apart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dao.apart.sector.GwangJinSectorDAO;
import com.ssafy.happy.model.dao.apart.sector.GwangJinSectorDAOImpl;

public class APART_SectorController implements Controller{
	GwangJinSectorDAO dao;
	public APART_SectorController() {
		dao = new GwangJinSectorDAOImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("sectors", dao.getSector());
		request.getRequestDispatcher("/apart/sector.jsp").forward(request, response);
	}
}
