package com.aniket.portal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bus_dispatch_mstr")
public class BusDispatchModel {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Bus_Dtls_Id", nullable = false)
	private Long busdtlsid;
	
	@Column(name = "Flag", nullable = false)
	private int flag;
	
	@Column(name = "Departure_Time", nullable = false)
	private String deptime;
	
	@Column(name = "Arrival_Time", nullable = false)
	private String arrivaltime;
	
	@Column(name = "Trip_Completed", nullable = false)
	private String tripcompleted;

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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getDeptime() {
		return deptime;
	}

	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getTripcompleted() {
		return tripcompleted;
	}

	public void setTripcompleted(String tripcompleted) {
		this.tripcompleted = tripcompleted;
	}

}