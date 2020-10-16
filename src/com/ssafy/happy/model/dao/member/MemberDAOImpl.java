package com.ssafy.happy.model.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.member.MemberDTO;


public class MemberDAOImpl implements MemberDAO {
	@Override
	public void insert(MemberDTO member) throws Exception {

		try (Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member(name, email, password, grade, tel, address ) VALUES ( ?, ?, ?, ?, ?, ? );")) {
			int index = 1;
	
			pstmt.setString(index++, member.getName());
			pstmt.setString(index++, member.getEmail());
			pstmt.setString(index++, member.getPassword());
			String p1 = "bronze";
			pstmt.setString(index++, p1);
			pstmt.setString(index++, member.getTel());
			pstmt.setString(index++, member.getAddress());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}

	}

	@Override
	public void update(MemberDTO member) throws Exception {
		// TODO Auto-generated method stub
		try (Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						  "UPDATE member "
						+ "   SET password = ? "
						+ " WHERE email = ?"
						);
				) {
			int index = 1;
			pstmt.setString(index++, member.getPassword());
			pstmt.setString(index++, member.getEmail());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public MemberDTO selectMemberByEmail(String email) throws Exception {
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from member where email = ?");
		) {
				pstmt.setString(1, email);
				ResultSet rs = pstmt.executeQuery();
				MemberDTO member = new MemberDTO();
				if(rs.next()) {
		
					member.setAddress(rs.getString("address"));
					member.setEmail(rs.getString("email"));
					member.setPassword(rs.getString("password"));
					member.setMemberno(rs.getInt("memberno"));
					member.setName(rs.getString("name"));
					member.setGrade(rs.getString("grade"));
					member.setTel(rs.getString("tel"));
				}
				System.out.println(member);
				return member;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<MemberDTO> selectUser() throws Exception {
		 List<MemberDTO> list = new ArrayList<MemberDTO>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from member");
		) {
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					MemberDTO member = new MemberDTO();					
		
					member.setAddress(rs.getString("address"));
					member.setEmail(rs.getString("email"));
					member.setPassword(rs.getString("password"));
					member.setMemberno(rs.getInt("memberno"));
					member.setName(rs.getString("name"));
					member.setGrade(rs.getString("grade"));
					member.setTel(rs.getString("tel"));
					list.add(member);
				}
				System.out.println(list.size());
				return list;
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void updateUserByEmail(MemberDTO member) throws Exception {
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("update member set position = ? where email = ? ");
		) {
			int index=1;

			pstmt.setString(index++, member.getEmail());
	
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
	 @Override
	   public void deleteUser(String email) throws Exception {
	      try (
	            Connection conn = DButil.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement( "delete from member where email = ?");
	      ) {
	            pstmt.setString(1, email);
	            pstmt.executeUpdate();
	      } catch (SQLException e) {
	         throw e;
	      }
	   
	      // TODO Auto-generated method stub
	      
	   }

	@Override
	public void updateMember(MemberDTO member) throws Exception {
		try (Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						  "UPDATE member "
						+ "   SET name=?, password = ?, tel=?,address=? "
						+ " WHERE email = ?"
						);
				) {
			int index = 1;
			pstmt.setString(index++, member.getName());
			pstmt.setString(index++, member.getPassword());
			pstmt.setString(index++, member.getTel());
			pstmt.setString(index++, member.getAddress());
			pstmt.setString(index++, member.getEmail());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}
	

}
