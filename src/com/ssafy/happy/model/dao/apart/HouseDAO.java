package com.ssafy.happy.model.dao.apart;

import java.util.List;

import com.ssafy.happy.model.dto.apart.HouseDealDTO;

public interface HouseDAO {

	/**
		 * 아파트 정보와 아파트 거래 정보를  xml String에서 읽어온다.
		 */
	//	public void loadData() {
	//		HouseParser parser = new HouseParser();
	//		deals = parser.getDeals();
	//		size = parser.getSize();
	//		search = new ArrayList<HouseDealDTO>(size);
	//	}

	List<HouseDealDTO> getAptDeal(String dong) throws Exception;

}