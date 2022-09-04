package com.aniket.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.pojos.BusDetailsRespPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.repository.BusDetailsRepo;

public interface FetchBusDetailsSrvc {
	BusDetailsRespPojo fetchbusdetails(String busid);
	Boolean validatebusid(String busid);
	List<BusDispatchModel> fetchuncompletedtrip(String busid);
	List<BusDispatchModel> fetchcompletedtrip(String busid);
}
