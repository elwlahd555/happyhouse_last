package com.ssafy.happy.model.service.apart;

import java.util.List;

import com.ssafy.happy.model.dto.apart.HouseDealDTO;

public interface HouseService {

	List<HouseDealDTO> selectHouse(String dong) throws Exception;

}