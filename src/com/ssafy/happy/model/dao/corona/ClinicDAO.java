package com.ssafy.happy.model.dao.corona;
import java.util.List;
import com.ssafy.happy.model.dto.corona.ClinicDTO;


public interface ClinicDAO {
	public List<ClinicDTO> selectIboard() throws Exception;
}
