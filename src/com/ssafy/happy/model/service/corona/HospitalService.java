package com.ssafy.happy.model.service.corona;

import java.util.List;
import com.ssafy.happy.model.dto.corona.HospitalDTO;


public interface HospitalService {
	public List<HospitalDTO> search() throws Exception;
	
}