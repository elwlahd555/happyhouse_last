package com.ssafy.happy.model.dao.corona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.corona.ClinicDTO;


public class ClinicDAOimpl implements ClinicDAO {
	@Override
	public List<ClinicDTO> selectIboard() throws Exception {
		List<ClinicDTO> list = new ArrayList<>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clinic c ORDER BY clinicid ");
		) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					
					ClinicDTO clinic = new ClinicDTO();
					clinic.setClinicaddress(rs.getString("clinicaddress"));
					clinic.setAvailable(rs.getString("available"));
					clinic.setSido(rs.getString("sido"));
					clinic.setGugun(rs.getString("gugun"));
					clinic.setClinicname(rs.getString("clinicname"));
					clinic.setWeekdaytime(rs.getString("weekdaytime"));
					clinic.setSaturdaytime(rs.getString("saturdaytime"));
					clinic.setRedtime(rs.getString("redtime"));
					clinic.setClinictel(rs.getString("clinictel"));
					list.add(clinic);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
	}

}
