package com.aniket.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bus_route_mstr")
public class BusRoutesModel {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Bus_Dtls_Id", nullable = false)
	private Long busdtlsid;
	
	@Column(name = "Location_Name", nullable = false)
	private String locationname;
	
	@Column(name = "Order_Id", nullable = false)
	private int orderid;

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

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

}