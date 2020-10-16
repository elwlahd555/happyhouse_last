package com.ssafy.happy.model.service.login;

import com.ssafy.happy.model.dao.login.LoginDAO;
import com.ssafy.happy.model.dao.login.LoginDAOImpl;
import com.ssafy.happy.model.dto.member.MemberDTO;

public class LoginServiceImpl implements LoginService  {
	private LoginDAO dao;
	public LoginServiceImpl() {
		dao = new LoginDAOImpl();
	}
	@Override
	public MemberDTO login(MemberDTO member) throws Exception {
		return dao.selectLogin(member);
	}
}
