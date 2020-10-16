package com.ssafy.happy.model.service.community;

import java.util.List;

import com.ssafy.happy.model.dto.community.InfoBoardDTO;

public interface InfoBoardService {
	public List<InfoBoardDTO> search() throws Exception;
	public void delete(int ino) throws Exception;
	public InfoBoardDTO showInfo(int ino) throws Exception;
	public void update(InfoBoardDTO iboard) throws Exception;
	public void add(InfoBoardDTO iboard) throws Exception;
}