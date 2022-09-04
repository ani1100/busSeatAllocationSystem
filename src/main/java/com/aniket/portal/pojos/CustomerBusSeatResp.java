package com.aniket.portal.pojos;

import java.util.List;

public class CustomerBusSeatResp {
	List<BusSeatPojo> listseat;
	CustomerBookingResp custbook;
	String status;
	String reason;
	public List<BusSeatPojo> getListseat() {
		return listseat;
	}
	public void setListseat(List<BusSeatPojo> listseat) {
		this.listseat = listseat;
	}
	public CustomerBookingResp getCustbook() {
		return custbook;
	}
	public void setCustbook(CustomerBookingResp custbook) {
		this.custbook = custbook;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
