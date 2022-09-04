package com.aniket.portal.service;

import java.io.PrintWriter;

import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;

public interface RegistrationSrvc {
	public Boolean savebusdetails(RegistrationReqPojo regpojo);
	public RegistrationRespPojo registersinglebusdetails(RegistrationReqPojo regpojo);
	public RegistrationRespPojo checkusername(String username);
}