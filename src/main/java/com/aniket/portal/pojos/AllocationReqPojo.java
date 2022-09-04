package com.aniket.portal.pojos;

import java.util.List;

import com.aniket.portal.model.CustomerDetailsModel;

public class AllocationReqPojo {
	CustomerDetailsModel custdtls;
	CustomerBusSeatResp busseatresp;
	List<Integer> seatnos;
	public CustomerDetailsModel getCustdtls() {
		return custdtls;
	}
	public void setCustdtls(CustomerDetailsModel custdtls) {
		this.custdtls = custdtls;
	}
	public CustomerBusSeatResp getBusseatresp() {
		return busseatresp;
	}
	public void setBusseatresp(CustomerBusSeatResp busseatresp) {
		this.busseatresp = busseatresp;
	}
	public List<Integer> getSeatnos() {
		return seatnos;
	}
	public void setSeatnos(List<Integer> seatnos) {
		this.seatnos = seatnos;
	}
	@Override
	public String toString() {
		return "AllocationReqPojo [custdtls=" + custdtls + ", busseatresp=" + busseatresp + ", seatnos=" + seatnos
				+ "]";
	}
	
}
