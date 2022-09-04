package com.aniket.portal.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.pojos.AllocationReqPojo;
import com.aniket.portal.pojos.CustomerBookingReqPojo;
import com.aniket.portal.pojos.CustomerBookingResp;
import com.aniket.portal.pojos.CustomerBusSeatResp;
import com.aniket.portal.pojos.RegistrationRespPojo;

public interface SeatBookingSrvc {
	public List<CustomerBookingResp> customerseatbooking(CustomerBookingReqPojo reqpojo);
	public CustomerBusSeatResp fetchbusseatdetails(CustomerBookingResp reqpojo);
	public RegistrationRespPojo allocateseats(AllocationReqPojo reqpojo);
}