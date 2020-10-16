package com.ssafy.happy.model.dao.apart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.apart.HouseDealDTO;
import com.ssafy.happy.model.dto.apart.SidoGugunDongDTO;
import com.ssafy.happy.model.util.HouseParser;


public class HouseDAOImpl implements HouseDAO  {
	
	private Map<String, List<HouseDealDTO>> deals;
	private int size;
	private List<HouseDealDTO> search;
	private String[] searchType= {HouseDealDTO.APT_DEAL, HouseDealDTO.APT_RENT, HouseDealDTO.HOUSE_DEAL, HouseDealDTO.HOUSE_RENT};
	public HouseDAOImpl() {
//		loadData();
	}
	
	/**
	 * 아파트 정보와 아파트 거래 정보를  xml String에서 읽어온다.
	 */
//	public void loadData() {
//		HouseParser parser = new HouseParser();
//		deals = parser.getDeals();
//		size = parser.getSize();
//		search = new ArrayList<HouseDealDTO>(size);
//	}
	
	@Override
	public List<HouseDealDTO> getAptDeal(String dong) throws Exception {
//		xml로 읽어올 때
//		search = deals.get(HouseDealDTO.APT_DEAL);
//		return search;
		
		
		List<HouseDealDTO> list = new ArrayList<HouseDealDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select h.no, h.dong, h.AptName , h.code , h.dealAmount , h.buildYear , h.dealYear , h.dealMonth , h.dealDay , h.area, h.floor , h.jibun , hi.lat, hi.lng ");
		sql.append("from housedeal h left join houseinfo hi ");
		sql.append("on h.AptName = hi.AptName and h.dong = hi.dong ");
		sql.append("where h.dong=(select dong from dongcode where dongcode = ?);");

		try (Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, dong);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseDealDTO house = new HouseDealDTO();
				house.setNo(Integer.parseInt(rs.getString("h.no")));
				house.setDong(rs.getString("h.dong"));
				house.setAptName(rs.getString("h.AptName"));
				house.setCode(Integer.parseInt(rs.getString("h.code")));
				house.setDealAmount(rs.getString("h.dealAmount"));
				house.setBuildYear(Integer.parseInt(rs.getString("h.buildYear")));
				house.setDealYear(Integer.parseInt(rs.getString("h.dealYear")));
				house.setDealMonth(Integer.parseInt(rs.getString("h.dealMonth")));
				house.setDealDay(Integer.parseInt(rs.getString("h.dealDay")));
				house.setArea(Double.parseDouble(rs.getString("h.area")));
				house.setFloor(Integer.parseInt(rs.getString("h.floor")));
				house.setJibun(rs.getString("h.jibun"));
				house.setLat(rs.getString("hi.lat"));
				house.setLng(rs.getString("hi.lng"));
				list.add(house);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
}
