package com.ssafy.happy.model.service.member;

import java.util.List;

import com.ssafy.happy.model.dto.member.MemberDTO;

public interface MemberService {

	void join(MemberDTO member) throws Exception;

	void update(MemberDTO member) throws Exception;

	MemberDTO searchByEmail(String email) throws Exception;
	
	List<MemberDTO> search() throws Exception;
	
	void updateByEmail(MemberDTO member) throws Exception;
	public void delete(String email) throws Exception ;


	void updateMember(MemberDTO member) throws Exception;
}