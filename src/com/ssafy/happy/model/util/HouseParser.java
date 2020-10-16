package com.ssafy.happy.model.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.happy.model.dto.apart.HouseDealDTO;

public class HouseParser {
	private Map<String, List<HouseDealDTO>> deals;
	private int size;
	
	public static int no;
	
	public HouseParser() {
		loadData();
	}
	
	private void loadData() {
		APTDealHandler  aptDealHandler = new APTDealHandler();
		aptDealHandler.getHouses();
		List<HouseDealDTO> aptDeals = aptDealHandler.getHouses();
		
		APTRentHandler  aptRentHandler = new APTRentHandler();
		aptRentHandler.getHouses();
		List<HouseDealDTO> aptRents = aptRentHandler.getHouses();
		
		BILLADealHandler  billaDealHandler = new BILLADealHandler();
		billaDealHandler.getHouses();
		List<HouseDealDTO> billaDeals = billaDealHandler.getHouses();
		
		BILLARentHandler  billaRentHandler = new BILLARentHandler();
		billaRentHandler.getHouses();
		List<HouseDealDTO> billaRents = billaRentHandler.getHouses();
		
		size = aptDeals.size()+aptRents.size()+billaDeals.size()+billaRents.size();
		System.out.println("--------------");
		System.out.println(aptDeals.size());
		System.out.println(aptRents.size());
		System.out.println(billaDeals.size());
		System.out.println(billaRents.size());
		System.out.println("--------------");
		deals = new HashMap<String, List<HouseDealDTO>>();
		
		deals.put(HouseDealDTO.APT_DEAL, aptDeals);
		deals.put(HouseDealDTO.APT_RENT, aptRents);
		deals.put(HouseDealDTO.HOUSE_DEAL, billaDeals);
		deals.put(HouseDealDTO.HOUSE_RENT, billaRents);
	}

	public Map<String, List<HouseDealDTO>> getDeals() {
		return deals;
	}

	public void setDeals(Map<String, List<HouseDealDTO>> deals) {
		this.deals = deals;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
