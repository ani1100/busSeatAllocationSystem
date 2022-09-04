package com.aniket.portal.pojos;

import com.aniket.portal.model.BusDetailsModel;
import com.aniket.portal.model.BusDispatchModel;

public class CustomerBookingResp {
	BusDetailsModel busdetails;
	BusDispatchModel scheduledbus;
	Boolean expansion;
	String startpoint;
	String endpoint;
	String deptime;
	String arrtime;
	String custstartloc;
	String custendloc;
	String custdeptime;
	public BusDetailsModel getBusdetails() {
		return busdetails;
	}
	public void setBusdetails(BusDetailsModel busdetails) {
		this.busdetails = busdetails;
	}
	public BusDispatchModel getScheduledbus() {
		return scheduledbus;
	}
	public void setScheduledbus(BusDispatchModel scheduledbus) {
		this.scheduledbus = scheduledbus;
	}
	public Boolean getExpansion() {
		return expansion;
	}
	public void setExpansion(Boolean expansion) {
		this.expansion = expansion;
	}
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
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
	public String getCuststartloc() {
		return custstartloc;
	}
	public void setCuststartloc(String custstartloc) {
		this.custstartloc = custstartloc;
	}
	public String getCustendloc() {
		return custendloc;
	}
	public void setCustendloc(String custendloc) {
		this.custendloc = custendloc;
	}
	public String getCustdeptime() {
		return custdeptime;
	}
	public void setCustdeptime(String custdeptime) {
		this.custdeptime = custdeptime;
	}

}
