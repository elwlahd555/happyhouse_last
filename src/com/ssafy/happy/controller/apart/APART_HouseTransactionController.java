package com.ssafy.happy.controller.apart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;

public class APART_HouseTransactionController implements Controller{
	
	public APART_HouseTransactionController() {
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/apart/houseTransaction.jsp").forward(request, response);
	}
}
