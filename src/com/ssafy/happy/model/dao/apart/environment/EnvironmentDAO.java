package com.ssafy.happy.model.dao.apart.environment;

import java.util.List;

import com.ssafy.happy.model.dto.environment.EnvironmentDTO;

public interface EnvironmentDAO {

	void loadData();

	List<EnvironmentDTO> getEnvironment() throws Exception; 

	List<EnvironmentDTO> search(String dong);

}