package com.ssafy.happy.model.dto.corona;

public class ClinicDTO {
	private int clinicid;    
	private String available;
	private String sido;
	private String gugun;
	private String clinicname;
	private String clinicaddress;
	private String weekdaytime;
	private String saturdaytime;
	private String redtime;
	private String clinictel;
	public int getClinicid() {
		return clinicid;
	}
	public void setClinicid(int clinicid) {
		this.clinicid = clinicid;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getClinicname() {
		return clinicname;
	}
	public void setClinicname(String clinicname) {
		this.clinicname = clinicname;
	}
	public String getClinicaddress() {
		return clinicaddress;
	}
	public void setClinicaddress(String clinicaddress) {
		this.clinicaddress = clinicaddress;
	}
	public String getWeekdaytime() {
		return weekdaytime;
	}
	public void setWeekdaytime(String weekdaytime) {
		this.weekdaytime = weekdaytime;
	}
	public String getSaturdaytime() {
		return saturdaytime;
	}
	public void setSaturdaytime(String saturdaytime) {
		this.saturdaytime = saturdaytime;
	}
	public String getRedtime() {
		return redtime;
	}
	public void setRedtime(String redtime) {
		this.redtime = redtime;
	}
	public String getClinictel() {
		return clinictel;
	}
	public void setClinictel(String clinictel) {
		this.clinictel = clinictel;
	}
	@Override
	public String toString() {
		return "ClinicDTO [clinicid=" + clinicid + ", available=" + available + ", sido=" + sido + ", gugun=" + gugun
				+ ", clinicname=" + clinicname + ", clinicaddress=" + clinicaddress + ", weekdaytime=" + weekdaytime
				+ ", saturdaytime=" + saturdaytime + ", redtime=" + redtime + ", clinictel=" + clinictel + "]";
	}
	
	
	
}
