package com.aniket.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cstmr_dtls_mstr")
public class CustomerDetailsModel {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Customer_Name", nullable = false)
	private String cstmrname;
	
	@Column(name = "Mobileno", nullable = false)
	private String mobileno;
	
	@Column(name = "Emailid")
	private String emailid;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCstmrname() {
		return cstmrname;
	}

	public void setCstmrname(String cstmrname) {
		this.cstmrname = cstmrname;
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

}