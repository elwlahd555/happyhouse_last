package com.ssafy.happy.controller.map;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dto.apart.HouseDealDTO;
import com.ssafy.happy.model.service.apart.HouseService;
import com.ssafy.happy.model.service.apart.HouseServiceImpl;

public class MAP_HouseController implements Controller{

	HouseService houseService;
	public MAP_HouseController() {
		houseService = new HouseServiceImpl();
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//jsp에서 선택한 아파트, 주택, 매매, 전월세에 따라서 넘길 값 다르게 만들어주기
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONArray arr = new JSONArray();
		
		try {
			System.out.println("여기는 MAP_HouseController");
			List<HouseDealDTO> list = houseService.selectHouse(request.getParameter("dong"));
			for(HouseDealDTO dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("no", dto.getNo());
				obj.put("dong", dto.getDong());
				obj.put("aptName", dto.getAptName());
				obj.put("code", dto.getCode());
				obj.put("dealAmount", dto.getDealAmount());
				obj.put("buildYear", dto.getBuildYear());
				obj.put("dealYear", dto.getDealYear());
				obj.put("dealMonth", dto.getDealMonth());
				obj.put("dealDay", dto.getDealDay());
				obj.put("area", dto.getArea());
				obj.put("floor", dto.getFloor());
				obj.put("jibun", dto.getJibun());
				obj.put("lat", dto.getLat());
				obj.put("lng", dto.getLng());
				arr.add(obj);
			}
			System.out.println("1111");
			System.out.println(arr.size());
			System.out.println(arr.toJSONString());
			
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr.toJSONString());
			out.close();
		}
	}

}
