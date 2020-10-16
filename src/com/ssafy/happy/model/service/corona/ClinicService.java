package com.ssafy.happy.model.service.corona;

import java.util.List;

import com.ssafy.happy.model.dto.corona.ClinicDTO;


public interface ClinicService {
	public List<ClinicDTO> search() throws Exception;
	
}