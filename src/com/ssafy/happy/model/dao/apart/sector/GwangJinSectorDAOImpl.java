package com.ssafy.happy.model.dao.apart.sector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ssafy.happy.common.DButil;
import com.ssafy.happy.model.dto.sector.SectorDTO;

public class GwangJinSectorDAOImpl implements GwangJinSectorDAO {

	List<SectorDTO> list = new ArrayList<>();

	public GwangJinSectorDAOImpl() {
		loadData();
	}

	@Override
	public void loadData() {
//		String csvFileName ="D:\\SSAFY\\workspace\\PJT04_HappyHouse\\WebContent\\resource\\sector\\소상공인시장진흥공단_상가(상권)정보_서울_20200630.csv";
//		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
//			String line;
//			br.readLine();
//			while ((line = br.readLine()) != null) {
//				SectorDTO tmp = new SectorDTO();
//				String[] values = line.split("\\|");
//				tmp.setName(values[1]);
//				tmp.setType1(values[4]);
//				tmp.setType2(values[6]);
//				tmp.setSido(values[12]);
//				tmp.setGungu(values[14]);
//				tmp.setDong(values[18]);
//				tmp.setAddress(values[31]);
//				tmp.setLon(values[37]);
//				tmp.setLat(values[38]);
//				list.add(tmp);
//			}
//		}catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public List<SectorDTO> getSector() throws Exception{
		List<SectorDTO> list = new ArrayList<>();
		try (
				Connection conn = DButil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM market m LIMIT 0,1000");
		) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					
					SectorDTO sector = new SectorDTO();
					sector.setSectionno(rs.getString("sectionno"));
					sector.setSectionname(rs.getString("sectionname"));
					sector.setBranchname(rs.getString("branchname"));
					sector.setMaincategory(rs.getString("maincategory"));
					sector.setSubcategory(rs.getString("subcategory"));
					sector.setSidocode(rs.getString("sidocode"));
					sector.setGuguncode(rs.getString("guguncode"));
					sector.setDongcode(rs.getString("dongcode"));

					sector.setAddress(rs.getString("address"));
					sector.setLon(rs.getString("lon"));
					sector.setLat(rs.getString("lat"));
					
					list.add(sector);
				}
				return list;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<SectorDTO> search(String dong) {
		List<SectorDTO> data = new ArrayList<>();
		for(SectorDTO env : list) {
//			System.out.println(env.getAddress());
//			System.out.println(dong);
//			System.out.println(env.getAddress().contains(dong));
			if(env.getAddress().contains(dong)) {
				data.add(env);
			}
		}
		return data;
	}
	
}
