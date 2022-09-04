package com.aniket.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus_dtls_mstr")
public class BusDetailsModel {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "No_of_Seats", nullable = false)
	private int seats;
	
	@Column(name = "No_of_Rows", nullable = false)
	private int rows;
	
	@Column(name = "Left_Side_Seat", nullable = false)
	private int seatleftside;
	
	@Column(name = "Right_Side_Seat", nullable = false)
	private int seatrightside;
	
	@Column(name = "Last_Seat")
	private int lastseat;
	
	@Column(name = "Bus_Name", nullable = false)
	private String busname;
	
	@Column(name = "Owner_Name", nullable = false)
	private String ownername;
	
	@Column(name = "Mobile_No", nullable = false)
	private String mobileno;
	
	@Column(name = "Emailid")
	private String emailid;
	
	@Column(name = "Endpoint1", nullable = false)
	private String endpoint1;
	
	@Column(name = "Endpoint2", nullable = false)
	private String endpoint2;
	
	@Column(name = "Bus_Number_Plate", nullable = false)
	private String busnumberplate;
	
	@Column(name = "Esthr", nullable = false)
	private int esthr;
	
	@Column(name = "Estmin", nullable = false)
	private int estmin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getLastseat() {
		return lastseat;
	}

	public void setLastseat(int lastseat) {
		this.lastseat = lastseat;
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

}
