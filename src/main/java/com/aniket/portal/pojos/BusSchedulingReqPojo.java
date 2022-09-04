package com.aniket.portal.pojos;

import java.util.List;

import com.aniket.portal.model.BusDetailsModel;

public class BusSchedulingReqPojo {
	BusDetailsModel busdetails;
	String deptime;
	String arrtime;
	int flag;
	List<String> locationname;
	public BusDetailsModel getBusdetails() {
		return busdetails;
	}
	public void setBusdetails(BusDetailsModel busdetails) {
		this.busdetails = busdetails;
	}
	public String getDeptime() {
		return deptime;
	}
	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}
	public String getArrtime() {
		return arrtime;
	}
	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}
	public int getFlag() {
		return flag;
	}
	public List<String> getLocationname() {
		return locationname;
	}
	public void setLocationname(List<String> locationname) {
		this.locationname = locationname;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "BusSchedulingReqPojo [busdetails=" + busdetails + ", deptime=" + deptime + ", arrtime=" + arrtime
				+ ", flag=" + flag + "]";
	}
	
}