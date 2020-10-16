package com.ssafy.happy.model.service.community;

import java.util.List;

import com.ssafy.happy.model.dto.community.QBoardDTO;

public interface QBoardService {
	public List<QBoardDTO> search() throws Exception;
}