package com.ssafy.happy.model.dao.community;

import java.util.List;

import com.ssafy.happy.model.dto.community.QBoardDTO;

public interface QBoardDAO {

	List<QBoardDTO> selectQboard() throws Exception;

}