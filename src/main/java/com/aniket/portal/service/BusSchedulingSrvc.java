package com.aniket.portal.service;

import com.aniket.portal.pojos.BusSchedulingReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;

public interface BusSchedulingSrvc {
	Boolean schedulebus(BusSchedulingReqPojo schbusreqpojo);
	RegistrationRespPojo schedulebusrequest(BusSchedulingReqPojo schbusreqpojo);

}