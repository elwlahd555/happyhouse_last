package com.ssafy.happy.model.service.environment;

import java.util.List;

import com.ssafy.happy.model.dao.apart.environment.EnvironmentDAO;
import com.ssafy.happy.model.dao.apart.environment.GwangJinEnvironmentDAOImpl;
import com.ssafy.happy.model.dto.environment.EnvironmentDTO;


public class GwangJinEnvironmentServiceImpl implements GwangJinEnvironmentService {
	private EnvironmentDAO dao;

	public GwangJinEnvironmentServiceImpl() {
		 dao = new GwangJinEnvironmentDAOImpl();
	}
	@Override
	public List<EnvironmentDTO> searchAll() throws Exception{
		return dao.getEnvironment();
	}
}
