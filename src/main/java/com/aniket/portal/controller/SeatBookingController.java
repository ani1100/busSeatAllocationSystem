package com.aniket.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.pojos.AllocationReqPojo;
import com.aniket.portal.pojos.CustomerBookingReqPojo;
import com.aniket.portal.pojos.CustomerBookingResp;
import com.aniket.portal.pojos.CustomerBusSeatResp;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.service.SeatBookingSrvc;


@RestController
public class SeatBookingController {
	@Autowired
	SeatBookingSrvc seatbooksrvc;
	@PostMapping("/customerseatbooking")
	public List<CustomerBookingResp> customerseatbooking(@RequestBody CustomerBookingReqPojo reqpojo)
	{
		return(seatbooksrvc.customerseatbooking(reqpojo));
	}
	@PostMapping("/fetchbusseatdetails")
	public CustomerBusSeatResp fetchbusseatdetails(@RequestBody CustomerBookingResp reqpojo)
	{
		return(seatbooksrvc.fetchbusseatdetails(reqpojo));
	}
	@PostMapping("/allocateseats")
	public RegistrationRespPojo allocateseats(@RequestBody AllocationReqPojo reqpojo)
	{
		return(seatbooksrvc.allocateseats(reqpojo));
	}

}