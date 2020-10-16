package com.ssafy.happy.model.service.login;

import com.ssafy.happy.model.dto.member.MemberDTO;

public interface LoginService {

	MemberDTO login(MemberDTO member) throws Exception;

}