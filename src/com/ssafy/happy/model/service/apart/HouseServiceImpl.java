package com.ssafy.happy.model.service.apart;

import java.util.List;

import com.ssafy.happy.model.dao.apart.HouseDAO;
import com.ssafy.happy.model.dao.apart.HouseDAOImpl;
import com.ssafy.happy.model.dto.apart.HouseDealDTO;


public class HouseServiceImpl implements HouseService{
	private HouseDAO dao;

	public HouseServiceImpl() {
		 dao = new HouseDAOImpl();
	}
	
	@Override
	public List<HouseDealDTO> selectHouse(String dong) throws Exception {
		System.out.println("여기는 HouseServiceImpl");
		List<HouseDealDTO> list = dao.getAptDeal(dong);
		return list;
	}
	
}
