package com.ssafy.happy.model.dao.community;

import java.util.List;

import com.ssafy.happy.model.dto.community.InfoBoardDTO;

public interface InfoBoardDAO {

	List<InfoBoardDTO> selectIboard() throws Exception;
	void deleteIboardByIno(int ino) throws Exception;
	InfoBoardDTO selectIboardByIno(int ino) throws Exception;
	void updateIBoard(InfoBoardDTO iboard) throws Exception;
	void InsertIBoard(InfoBoardDTO iboard) throws Exception;
}