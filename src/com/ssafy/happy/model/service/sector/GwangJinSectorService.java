package com.ssafy.happy.model.service.sector;

import java.util.List;

import com.ssafy.happy.model.dto.sector.SectorDTO;

public interface GwangJinSectorService {

	List<SectorDTO> searchAll() throws Exception;

}