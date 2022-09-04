package com.aniket.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seat_allocation_mstr")
public class SeatAllocationModel {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Bus_Dtls_Id", nullable = false)
	private Long busdtlsid;
	
	@Column(name = "Bus_Sch_Id", nullable = false)
	private Long busschid;
	
	@Column(name = "Seat_No", nullable = false)
	private int seatno;
	
	@Column(name = "Location_Order_id", nullable = false)
	private int locationorderid;
	
	@Column(name = "Allocation", nullable = false,updatable=true)
	private String allocation;
	
	@Column(name = "Cstmr_Dtls_Id",updatable=true)
	private Long cstmrdtlsid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusdtlsid() {
		return busdtlsid;
	}

	public void setBusdtlsid(Long busdtlsid) {
		this.busdtlsid = busdtlsid;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}



	public int getLocationorderid() {
		return locationorderid;
	}

	public void setLocationorderid(int locationorderid) {
		this.locationorderid = locationorderid;
	}

	public String getAllocation() {
		return allocation;
	}

	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}

	public Long getCstmrdtlsid() {
		return cstmrdtlsid;
	}

	public void setCstmrdtlsid(Long cstmrdtlsid) {
		this.cstmrdtlsid = cstmrdtlsid;
	}

	public Long getBusschid() {
		return busschid;
	}

	public void setBusschid(Long busschid) {
		this.busschid = busschid;
	}
	

}
