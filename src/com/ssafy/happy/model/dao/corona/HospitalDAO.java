package com.ssafy.happy.model.dao.corona;
import java.util.List;

import com.ssafy.happy.model.dto.corona.HospitalDTO;



public interface HospitalDAO {
	public List<HospitalDTO> selectHospital() throws Exception;
}
