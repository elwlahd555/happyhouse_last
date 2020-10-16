package com.ssafy.happy.model.service.community;

import java.util.List;

import com.ssafy.happy.model.dao.community.InfoBoardDAO;
import com.ssafy.happy.model.dao.community.InfoBoardDAOimpl;
import com.ssafy.happy.model.dto.community.InfoBoardDTO;


public class InfoBoardServiceImpl implements InfoBoardService {
	private InfoBoardDAO dao;
	
	public InfoBoardServiceImpl() {
		dao = new InfoBoardDAOimpl();
	}
	
	public List<InfoBoardDTO> search() throws Exception{
		return dao.selectIboard();
	}

	@Override
	public void delete(int ino) throws Exception {
		dao.deleteIboardByIno(ino);
	}

	@Override
	public InfoBoardDTO showInfo(int ino) throws Exception {
		return dao.selectIboardByIno(ino);
	}

	@Override
	public void update(InfoBoardDTO iboard) throws Exception {
		dao.updateIBoard(iboard);
	}

	@Override
	public void add(InfoBoardDTO iboard) throws Exception {
		dao.InsertIBoard(iboard);
		
	}
}
