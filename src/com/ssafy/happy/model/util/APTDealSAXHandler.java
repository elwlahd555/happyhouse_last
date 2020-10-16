package com.ssafy.happy.model.util;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.happy.model.dto.apart.HouseDealDTO;



public class APTDealSAXHandler extends DefaultHandler {
	
	/**아파트 거래 정보를 담는다 */
	private List<HouseDealDTO> houses;
	/**파상힌 아파트 거래 정보*/
	private HouseDealDTO house;
	/**태그 바디 정보를 임시로 저장*/
	private String temp;
	
	public APTDealSAXHandler(){
		houses = new LinkedList<HouseDealDTO>();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes att){
		if(qName.equals("item")){
			house = new HouseDealDTO(HouseParser.no++);
			house.setType(HouseDealDTO.APT_DEAL);
			houses.add(house);
		}
	}
	
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("지역코드")) { 
			house.setCode(Integer.parseInt(temp));
		}else if(qName.equals("아파트")) { 
			house.setAptName(temp.trim());
		}else if(qName.equals("법정동")) { 
			house.setDong(temp.trim());
		}else if(qName.equals("거래금액")) { 
			house.setDealAmount(temp);
		}else if(qName.equals("건축년도")) { 
			house.setBuildYear(Integer.parseInt(temp));
		}else if(qName.equals("년")) { 
			house.setDealYear(Integer.parseInt(temp));
		}else if(qName.equals("월")) { 
			house.setDealMonth(Integer.parseInt(temp));
		}else if(qName.equals("일")) { 
			house.setDealDay(Integer.parseInt(temp));
		}else if(qName.equals("전용면적")) { 
			house.setArea(Double.parseDouble(temp));
		}else if(qName.equals("지번")) { 
			house.setJibun(temp);
		}else if(qName.equals("층")) { 
			house.setFloor(Integer.parseInt(temp));
		}
	}
	
	public void characters(char[]ch, int start, int length){
		temp = new String(ch, start, length);
	}
	public List<HouseDealDTO> getHouses() {
		return houses;
	}
	public void setHouses(List<HouseDealDTO> houses) {
		this.houses = houses;
	}
}
