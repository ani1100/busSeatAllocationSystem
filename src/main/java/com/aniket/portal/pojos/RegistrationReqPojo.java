package com.aniket.portal.pojos;

import java.util.List;

public class RegistrationReqPojo {
	private int seats; 
	private int rows; 
	private int seatleftside; 
	private int seatrightside; 
	private int seatlastseat; 
	private String busname; 
	private String ownername; 
	private String mobileno; 
	private String emailid; 
	private String endpoint1; 
	private String endpoint2; 
	private String busnumberplate;
	private List<String> lisstoppages;
	private int esthr;
	private int estmin;
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getSeatleftside() {
		return seatleftside;
	}
	public void setSeatleftside(int seatleftside) {
		this.seatleftside = seatleftside;
	}
	public int getSeatrightside() {
		return seatrightside;
	}
	public void setSeatrightside(int seatrightside) {
		this.seatrightside = seatrightside;
	}
	public int getSeatlastseat() {
		return seatlastseat;
	}
	public void setSeatlastseat(int seatlastseat) {
		this.seatlastseat = seatlastseat;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getEndpoint1() {
		return endpoint1;
	}
	public void setEndpoint1(String endpoint1) {
		this.endpoint1 = endpoint1;
	}
	public String getEndpoint2() {
		return endpoint2;
	}
	public void setEndpoint2(String endpoint2) {
		this.endpoint2 = endpoint2;
	}
	public String getBusnumberplate() {
		return busnumberplate;
	}
	public void setBusnumberplate(String busnumberplate) {
		this.busnumberplate = busnumberplate;
	}
	public List<String> getLisstoppages() {
		return lisstoppages;
	}
	public void setLisstoppages(List<String> lisstoppages) {
		this.lisstoppages = lisstoppages;
	}
	
	public int getEsthr() {
		return esthr;
	}
	public void setEsthr(int esthr) {
		this.esthr = esthr;
	}
	public int getEstmin() {
		return estmin;
	}
	public void setEstmin(int estmin) {
		this.estmin = estmin;
	}
	@Override
	public String toString() {
		return "RegistrationReqPojo [seats=" + seats + ", rows=" + rows + ", seatleftside=" + seatleftside
				+ ", seatrightside=" + seatrightside + ", seatlastseat=" + seatlastseat + ", busname=" + busname
				+ ", ownername=" + ownername + ", mobileno=" + mobileno + ", emailid=" + emailid + ", endpoint1="
				+ endpoint1 + ", endpoint2=" + endpoint2 + ", busnumberplate=" + busnumberplate
				+ ", lisstoppages=" + lisstoppages + "]";
	}

}