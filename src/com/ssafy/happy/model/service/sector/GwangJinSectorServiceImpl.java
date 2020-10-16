package com.ssafy.happy.model.service.sector;

import java.util.List;

import com.ssafy.happy.model.dao.apart.sector.GwangJinSectorDAO;
import com.ssafy.happy.model.dao.apart.sector.GwangJinSectorDAOImpl;
import com.ssafy.happy.model.dto.sector.SectorDTO;


public class GwangJinSectorServiceImpl implements GwangJinSectorService {
	private GwangJinSectorDAO dao;

	public GwangJinSectorServiceImpl() {
		 dao = new GwangJinSectorDAOImpl();
	}
	@Override
	public List<SectorDTO> searchAll() throws Exception{
		return dao.getSector();
	}
}
