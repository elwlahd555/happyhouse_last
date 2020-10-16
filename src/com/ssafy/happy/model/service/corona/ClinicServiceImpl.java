package com.ssafy.happy.model.service.corona;

import java.util.List;

import com.ssafy.happy.model.dao.corona.ClinicDAO;
import com.ssafy.happy.model.dao.corona.ClinicDAOimpl;
import com.ssafy.happy.model.dto.corona.ClinicDTO;


public class ClinicServiceImpl implements ClinicService {
	private ClinicDAO dao;
	
	public ClinicServiceImpl() {
		dao = new ClinicDAOimpl();
	}

	@Override
	public List<ClinicDTO> search() throws Exception {
		return dao.selectIboard();
	}
	

}
