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

public class DongServiceImpl implements Controller, SidoService, GugunService, DongService{
	
	SidoGugunDongDAO sidoGugunDongDAO;
	public DongServiceImpl() {
		sidoGugunDongDAO = new SidoGugunDongDAOImpl();
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONArray arr = new JSONArray();
		try {
			List<SidoGugunDongDTO> list = sidoGugunDongDAO.getDongInGugun(request.getParameter("gugun"));
			
			for(SidoGugunDongDTO dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("dong_code", dto.getDongCode());
				obj.put("dong_name", dto.getDongName());
				System.out.println(dto.getDongCode()+" "+dto.getDongName());
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
