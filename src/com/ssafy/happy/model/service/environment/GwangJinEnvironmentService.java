package com.ssafy.happy.model.service.environment;

import java.util.List;

import com.ssafy.happy.model.dto.environment.EnvironmentDTO;

public interface GwangJinEnvironmentService {

	List<EnvironmentDTO> searchAll() throws Exception;
 
}