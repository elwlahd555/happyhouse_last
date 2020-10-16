package com.ssafy.happy.model.dao.map;

import java.util.List;

import com.ssafy.happy.model.dto.apart.SidoGugunDongDTO;

public interface SidoGugunDongDAO {

	List<SidoGugunDongDTO> getSido() throws Exception;

	List<SidoGugunDongDTO> getGugunInSido(String sido) throws Exception;

	List<SidoGugunDongDTO> getDongInGugun(String gugun) throws Exception;

}