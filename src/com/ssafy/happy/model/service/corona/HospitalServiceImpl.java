package com.ssafy.happy.model.service.corona;

import java.util.List;

import com.ssafy.happy.model.dao.corona.HospitalDAO;
import com.ssafy.happy.model.dao.corona.HospitalDAOimpl;
import com.ssafy.happy.model.dto.corona.HospitalDTO;


public class HospitalServiceImpl implements HospitalService {
	private HospitalDAO dao;
	
	public HospitalServiceImpl() {
		dao = new HospitalDAOimpl();
	}

	@Override
	public List<HospitalDTO> search() throws Exception {
		return dao.selectHospital();
	}
	

}
