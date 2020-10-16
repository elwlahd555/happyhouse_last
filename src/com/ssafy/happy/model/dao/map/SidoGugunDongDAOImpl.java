package com.ssafy.happy.model.dao.map;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.apart.SidoGugunDongDTO;

public class SidoGugunDongDAOImpl implements SidoGugunDongDAO {

	@Override
	public List<SidoGugunDongDTO> getSido() throws Exception {

		List<SidoGugunDongDTO> list = new ArrayList<SidoGugunDongDTO>();
		try (Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"select left(sido_code,2) sido_code, sido_name from sidocode order by sido_code");) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("sido_code"));
				SidoGugunDongDTO sido = new SidoGugunDongDTO();
				sido.setSidoCode(rs.getString("sido_code"));
				sido.setSidoName(rs.getString("sido_name"));

				list.add(sido);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<SidoGugunDongDTO> getGugunInSido(String sido) throws Exception {

		List<SidoGugunDongDTO> list = new ArrayList<SidoGugunDongDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT left(gugun_code,5) gugun_code, gugun_name FROM guguncode \n");
		sql.append("where left(gugun_code,2) = ?");
		sql.append("ORDER BY gugun_code");

		try (
				Connection conn = DButil.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, sido);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SidoGugunDongDTO gugun = new SidoGugunDongDTO();
				gugun.setGugunCode(rs.getString("gugun_code"));
				gugun.setGugunName(rs.getString("gugun_name"));

				list.add(gugun);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<SidoGugunDongDTO> getDongInGugun(String gugun) throws Exception {
		
		List<SidoGugunDongDTO> list = new ArrayList<SidoGugunDongDTO>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT dongcode, dong FROM dongcode \n");
		sql.append("where left(dongcode,5) = ?");
		sql.append("ORDER BY dongcode");
		
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
				pstmt.setString(1, gugun);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SidoGugunDongDTO dong = new SidoGugunDongDTO();
					dong.setDongCode(rs.getString("dongcode"));
					dong.setDongName(rs.getString("dong"));

					list.add(dong);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
		
			
	}
}

