package com.ssafy.happy.model.dao.member;

import java.util.List;

import com.ssafy.happy.model.dto.member.MemberDTO;

public interface MemberDAO {

	void insert(MemberDTO member) throws Exception;

	void update(MemberDTO member) throws Exception;

	MemberDTO selectMemberByEmail(String email) throws Exception;
	List<MemberDTO> selectUser()throws Exception;
	void updateUserByEmail(MemberDTO member) throws Exception;

	void deleteUser(String email) throws Exception;

	void updateMember(MemberDTO member) throws Exception;
}