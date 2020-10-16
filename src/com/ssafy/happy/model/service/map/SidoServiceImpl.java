package com.ssafy.happy.model.service.map;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.dao.map.SidoGugunDongDAO;
import com.ssafy.happy.model.dao.map.SidoGugunDongDAOImpl;
import com.ssafy.happy.model.dto.apart.SidoGugunDongDTO;

public class SidoServiceImpl implements Controller, SidoService{
	
	SidoGugunDongDAO sidoGugunDongDAO;
	public SidoServiceImpl() {
		sidoGugunDongDAO = new SidoGugunDongDAOImpl();
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONArray arr = new JSONArray();
		try {
			List<SidoGugunDongDTO> list = sidoGugunDongDAO.getSido();
			for(SidoGugunDongDTO dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("sido_code", dto.getSidoCode());
				obj.put("sido_name", dto.getSidoName());
				arr.add(obj);
			}
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
