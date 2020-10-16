package com.ssafy.happy.model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.community.QBoardDTO;


public class QBoardDAOimpl implements QBoardDAO {
	@Override
	public List<QBoardDTO> selectQboard() throws Exception {
		List<QBoardDTO> list = new ArrayList<>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from qboard order by qno");
		) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("qno"));
					QBoardDTO qboard = new QBoardDTO();
					qboard.setQno(rs.getInt("qno"));
					qboard.setTitle(rs.getString("title"));
					qboard.setContent(rs.getString("content"));
					qboard.setWriter(rs.getString("writer"));
					qboard.setViewcnt(rs.getInt("viewcnt"));
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String strDateTime = format.format(rs.getDate("wday"));
					qboard.setWday(strDateTime);

					list.add(qboard);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
