package com.ssafy.happy.model.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.member.MemberDTO;

public class LoginDAOImpl implements LoginDAO {
	
	public LoginDAOImpl() {
	}
	
	
	@Override
	public MemberDTO selectLogin(MemberDTO param) throws Exception {
		MemberDTO member = null;
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from member where email = ? and password = ?");
		) {
				pstmt.setString(1, param.getEmail());
				pstmt.setString(2, param.getPassword());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					member = new MemberDTO();
				
					member.setEmail(rs.getString("email"));
					member.setPassword(rs.getString("password"));
				
				}
				return member;
		} catch (SQLException e) {
			throw e;
		}
	}
}