package com.ssafy.happy.model.dao.login;

import com.ssafy.happy.model.dto.member.MemberDTO;

public interface LoginDAO {

	MemberDTO selectLogin(MemberDTO param) throws Exception;

}