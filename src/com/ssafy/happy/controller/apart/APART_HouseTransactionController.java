package com.ssafy.happy.controller.apart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dao.apart.HouseDAO;
import com.ssafy.happy.model.dao.apart.HouseDAOImpl;

public class APART_HouseTransactionController implements Controller{
	HouseDAO dao;
	public APART_HouseTransactionController() {
		dao = new HouseDAOImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//jsp에서 선택한 아파트, 주택, 매매, 전월세에 따라서 넘길 값 다르게 만들어주기
		
		//동에 따라서 해당 동 정보를 찾아올 수 있도록 해야함!
		
		request.setAttribute("houses", dao.getAptDeal());
		request.getRequestDispatcher("/apart/houseTransaction.jsp").forward(request, response);
	}
}
