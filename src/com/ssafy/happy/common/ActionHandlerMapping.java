package com.ssafy.happy.common;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.controller.mainController;
import com.ssafy.happy.controller.apart.APART_AirpullController;
import com.ssafy.happy.controller.apart.APART_HouseTransactionController;
import com.ssafy.happy.controller.apart.APART_SectorController;
import com.ssafy.happy.controller.community.Community_InfoController;
import com.ssafy.happy.controller.community.Community_InfoDeleteController;
import com.ssafy.happy.controller.community.Community_InfoDetailController;
import com.ssafy.happy.controller.community.Community_InfoInsertController;
import com.ssafy.happy.controller.community.Community_InfoMoveController;
import com.ssafy.happy.controller.community.Community_InfoUpdateController;
import com.ssafy.happy.controller.community.Community_IntroduceController;
import com.ssafy.happy.controller.community.Community_QandAListAController;
import com.ssafy.happy.controller.community.Community_TablesController;
import com.ssafy.happy.controller.corona.Corona_ClinicController;
import com.ssafy.happy.controller.corona.Corona_HospitalController;
import com.ssafy.happy.controller.login.LOGIN_DeleteController;
import com.ssafy.happy.controller.login.LOGIN_FindPassController;
import com.ssafy.happy.controller.login.LOGIN_JoinController;
import com.ssafy.happy.controller.login.LOGIN_LoginController;
import com.ssafy.happy.controller.login.LOGIN_LogoutController;
import com.ssafy.happy.controller.login.LOGIN_MypageController;
import com.ssafy.happy.controller.login.LOGIN_RegisterController;
import com.ssafy.happy.controller.login.LOGIN_ResetPassController;
import com.ssafy.happy.controller.login.LOGIN_UpdateController;
import com.ssafy.happy.controller.map.MAP_DongController;
import com.ssafy.happy.controller.map.MAP_GugunController;
import com.ssafy.happy.controller.map.MAP_HouseController;
import com.ssafy.happy.controller.map.MAP_SidoController;
import com.ssafy.happy.controller.user.USER_DELETEController;
import com.ssafy.happy.controller.user.USER_DetailController;
import com.ssafy.happy.controller.user.USER_InsertController;
import com.ssafy.happy.controller.user.USER_InterestController;
import com.ssafy.happy.controller.user.USER_LIstController;
import com.ssafy.happy.controller.user.USER_UPDATEController;


public class ActionHandlerMapping {
		private Map<String,Controller> mapping = new HashMap<>();
		
		public ActionHandlerMapping() {
			mapping.put("MAIN", new mainController());
			
			mapping.put("USER_LIST", new USER_LIstController());
			mapping.put("USER_ADD", new USER_InsertController());
			mapping.put("USER_DETAIL", new USER_DetailController());
			mapping.put("USER_UPDATE", new USER_UPDATEController());
			mapping.put("USER_DELETE", new USER_DELETEController());
			mapping.put("INTEREST", new USER_InterestController());
			
	         mapping.put("LOGOUT", new LOGIN_LogoutController());
	         mapping.put("LOGIN", new LOGIN_LoginController());
	         mapping.put("FINDPASS", new LOGIN_FindPassController());
	         mapping.put("RESETPASS", new LOGIN_ResetPassController());
	         mapping.put("REGISTER", new LOGIN_RegisterController());
	         mapping.put("JOIN", new LOGIN_JoinController());
	         mapping.put("MYPAGE", new LOGIN_MypageController());
	         mapping.put("DELETE", new LOGIN_DeleteController());
	         mapping.put("UPDATE", new LOGIN_UpdateController());

			
			
			mapping.put("MAP_SIDO", new MAP_SidoController());
			mapping.put("MAP_GUGUN", new MAP_GugunController());
			mapping.put("MAP_DONG", new MAP_DongController());
			mapping.put("MAP_HOUSE", new MAP_HouseController());
			
			
			mapping.put("APT_AIRPULL", new APART_AirpullController());
			mapping.put("APT_SECTOR", new APART_SectorController());
			mapping.put("APT_HOUSETRANSACTION", new APART_HouseTransactionController());
			

			
			mapping.put("COM_INTRODUCE", new Community_IntroduceController());
			mapping.put("COM_TABLES_LIST", new Community_TablesController());
			mapping.put("COM_QA_LIST", new Community_QandAListAController());
			mapping.put("COM_INFO_LIST", new Community_InfoController());
			mapping.put("COM_INFO_DELETE", new Community_InfoDeleteController());
			mapping.put("COM_INFO_DETAIL", new Community_InfoDetailController());
			mapping.put("COM_INFO_UPDATE", new Community_InfoUpdateController());
			mapping.put("COM_INFO_MOVE", new Community_InfoMoveController());
			mapping.put("COM_INFO_INSERT", new Community_InfoInsertController());
			mapping.put("COM_INFO_CLINIC", new Corona_ClinicController());
			mapping.put("COM_INFO_HOSPITAL", new Corona_HospitalController());
			
		//	mapping.put("COM_INFO_CLINIC",new CORONA_ClinicController());
			
			
		}
		
		public Controller getController(String action) {
			return mapping.get(action);
		}
}
