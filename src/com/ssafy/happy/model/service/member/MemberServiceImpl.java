package com.ssafy.happy.model.service.member;

import java.util.List;

import com.ssafy.happy.model.dao.member.MemberDAO;
import com.ssafy.happy.model.dao.member.MemberDAOImpl;
import com.ssafy.happy.model.dto.member.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao;
	public MemberServiceImpl() {
		dao=new MemberDAOImpl();
	}
	@Override
	public void join(MemberDTO member) throws Exception{
		dao.insert(member);
	}
	@Override
	public void update(MemberDTO member) throws Exception {
		// TODO Auto-generated method stub
		dao.update(member);
	}
	@Override
	public MemberDTO searchByEmail(String email) throws Exception {
		return dao.selectMemberByEmail(email);
	}
	@Override
	public List<MemberDTO> search() throws Exception {
		
		return dao.selectUser();
	}
	@Override
	public void updateByEmail(MemberDTO member) throws Exception {
		dao.updateUserByEmail(member);
		
	}
	@Override
	public void delete(String email) throws Exception {
		dao.deleteUser(email);

	}

	@Override
	public void updateMember(MemberDTO member) throws Exception {
		// TODO Auto-generated method stub
		dao.updateMember(member);
	}
}
