package com.ssafy.happy.model.dao.corona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.corona.HospitalDTO;


public class HospitalDAOimpl implements HospitalDAO {
	@Override
	public List<HospitalDTO> selectHospital() throws Exception {
		List<HospitalDTO> list = new ArrayList<>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM hospital h ORDER BY hospitalid ");
		) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					
					HospitalDTO hospital = new HospitalDTO();
					hospital.setSido(rs.getString("sido"));
					hospital.setGugun(rs.getString("gugun"));
					hospital.setHospitalname(rs.getString("hospitalname"));
					hospital.setHospitaladdress(rs.getString("hospitaladdress"));
					hospital.setApply(rs.getString("apply"));
					hospital.setHospitaltel(rs.getString("hospitaltel"));
					list.add(hospital);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
	}

}
