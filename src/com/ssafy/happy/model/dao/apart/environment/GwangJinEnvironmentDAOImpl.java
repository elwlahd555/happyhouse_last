package com.ssafy.happy.model.dao.apart.environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.corona.HospitalDTO;
import com.ssafy.happy.model.dto.environment.EnvironmentDTO;

public class GwangJinEnvironmentDAOImpl implements EnvironmentDAO {

	List<EnvironmentDTO> list = new ArrayList<>();

	public GwangJinEnvironmentDAOImpl() {
		loadData();
	}

	@Override
	public void loadData() {
//		String csvFileName ="D:\\SSAFY\\workspace\\PJT04_HappyHouse\\WebContent\\resource\\environment\\서울시 광진구 환경 지도점검 내역 현황.csv";
//		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
//			String line;
//
//			while ((line = br.readLine()) != null) {
//				EnvironmentDTO tmp = new EnvironmentDTO();
//
//				String[] values = line.split(",");
//
//				tmp.setName(values[0].replaceAll("\\\"",""));
//				tmp.setPerm_code(values[1].replaceAll("\\\"",""));
//				tmp.setType(values[3].replaceAll("\\\"",""));
//				tmp.setDescription(values[9].replaceAll("\\\"",""));
//				tmp.setAddress(values[12].replaceAll("\\\"",""));
//				list.add(tmp);
//			}
//		}catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public List<EnvironmentDTO> getEnvironment() throws Exception {
		List<EnvironmentDTO> list = new ArrayList<>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM pollution p ");
		) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					
					EnvironmentDTO environment = new EnvironmentDTO();
					environment.setLicenseno(rs.getString("licenseno"));
					environment.setCompany(rs.getString("company"));
					environment.setSectorscode(rs.getString("sectorscode"));
					environment.setSectorsname(rs.getString("sectorsname"));
					environment.setCheckdate(rs.getString("checkdate"));
					char target = ' ';
					
					if(rs.getString("Disposaltarget").length() != 0 )  target = rs.getString("Disposaltarget").charAt(0);
				
					environment.setDisposaltarget(target);
					environment.setChecklisting(rs.getString("checklisting"));
					environment.setCheckresult(rs.getString("checkresult"));
					environment.setAddress(rs.getString("address"));
					
					list.add(environment);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<EnvironmentDTO> search(String dong) {
		List<EnvironmentDTO> data = new ArrayList<>();
		for(EnvironmentDTO env : list) {
			if(env.getAddress().contains(dong)) {
				data.add(env);
			}
		}
		return data;
	}
	
}
