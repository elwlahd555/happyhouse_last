package com.ssafy.happy.model.service.community;

import java.util.List;

import com.ssafy.happy.model.dao.community.QBoardDAO;
import com.ssafy.happy.model.dao.community.QBoardDAOimpl;
import com.ssafy.happy.model.dto.community.QBoardDTO;


public class QBoardServiceImpl implements QBoardService {
	private QBoardDAO dao;
	
	public QBoardServiceImpl() {
		dao = new QBoardDAOimpl();
	}
	
	public List<QBoardDTO> search() throws Exception{
		return dao.selectQboard();
	}
}
