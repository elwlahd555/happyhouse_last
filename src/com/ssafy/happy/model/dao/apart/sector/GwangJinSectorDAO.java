package com.ssafy.happy.model.dao.apart.sector;

import java.util.List;

import com.ssafy.happy.model.dto.sector.SectorDTO;

public interface GwangJinSectorDAO {

	void loadData();

	List<SectorDTO> getSector() throws Exception;

	List<SectorDTO> search(String dong);

}