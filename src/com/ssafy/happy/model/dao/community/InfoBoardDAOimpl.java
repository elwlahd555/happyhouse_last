package com.ssafy.happy.model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.community.InfoBoardDTO;

public class InfoBoardDAOimpl implements InfoBoardDAO {
	@Override
	public List<InfoBoardDTO> selectIboard() throws Exception {
		List<InfoBoardDTO> list = new ArrayList<>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from infoboard order by ino");
		) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					
					InfoBoardDTO infoboard = new InfoBoardDTO();
					infoboard.setIno(rs.getInt("ino"));
					infoboard.setTitle(rs.getString("title"));
					infoboard.setContent(rs.getString("content"));
					infoboard.setWriter(rs.getString("writer"));
					infoboard.setPosition(rs.getString("position"));
					infoboard.setViewcnt(rs.getInt("viewcnt"));
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String strDateTime = format.format(rs.getDate("wday"));
					infoboard.setWday(strDateTime);

					list.add(infoboard);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteIboardByIno(int ino) throws Exception {
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from infoboard where ino = ? ");
		) {
			pstmt.setInt(1, ino);
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public InfoBoardDTO selectIboardByIno(int ino) throws Exception {
	
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from infoboard where ino = ? ");
		) {
				pstmt.setInt(1, ino);
				ResultSet rs = pstmt.executeQuery();
				InfoBoardDTO infoboard = new InfoBoardDTO();
				if(rs.next()) {					
					infoboard.setIno(rs.getInt("ino"));
					infoboard.setTitle(rs.getString("title"));
					infoboard.setContent(rs.getString("content"));
					infoboard.setWriter(rs.getString("writer"));
					infoboard.setViewcnt(rs.getInt("viewcnt"));
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String strDateTime = format.format(rs.getDate("wday"));
					infoboard.setWday(strDateTime);				
				}
				return infoboard;
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void updateIBoard(InfoBoardDTO iboard) throws Exception {
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("update infoboard set title = ?, content = ? where ino = ? ");
		) {
			int index=1;
			pstmt.setString(index++, iboard.getTitle());
			pstmt.setString(index++, iboard.getContent());
			pstmt.setInt(index++, iboard.getIno());
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void InsertIBoard(InfoBoardDTO iboard) throws Exception {
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into infoboard(title,content,writer,position,viewcnt,wday) values(?, ?, ?, ?, ?, ? ) ");
		) {
			int index=1;
			pstmt.setString(index++, iboard.getTitle());
			pstmt.setString(index++, iboard.getContent());
			pstmt.setString(index++, iboard.getWriter());
			pstmt.setString(index++, iboard.getPosition());
			pstmt.setInt(index++, 0);
			pstmt.setString(index++, iboard.getWday());
		
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
