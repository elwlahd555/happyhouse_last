package com.ssafy.happy.model.dao.apart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.happy.model.dto.apart.HouseDealDTO;
import com.ssafy.happy.model.util.HouseParser;


public class HouseDAOImpl implements HouseDAO {
	
	private Map<String, List<HouseDealDTO>> deals;
	private int size;
	private List<HouseDealDTO> search;
	private String[] searchType= {HouseDealDTO.APT_DEAL, HouseDealDTO.APT_RENT, HouseDealDTO.HOUSE_DEAL, HouseDealDTO.HOUSE_RENT};
	public HouseDAOImpl() {
		loadData();
	}
	
	/**
	 * 아파트 정보와 아파트 거래 정보를  xml String에서 읽어온다.
	 */
	public void loadData() {
		HouseParser parser = new HouseParser();
		deals = parser.getDeals();
		size = parser.getSize();
		search = new ArrayList<HouseDealDTO>(size);
	}
	
	@Override
	public List<HouseDealDTO> getAptDeal() {
		search = deals.get(HouseDealDTO.APT_DEAL);
		
		System.out.println("-------------------");
		for (int i = 0; i < search.size(); i++) {
			System.out.println(search.get(i).toString());
		}
		System.out.println("-------------------");
		
		return search;
	}
	
}
