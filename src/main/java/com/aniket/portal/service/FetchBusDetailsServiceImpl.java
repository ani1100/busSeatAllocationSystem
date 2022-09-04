package com.aniket.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.portal.model.BusDetailsModel;
import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.model.BusRoutesModel;
import com.aniket.portal.pojos.BusDetailsRespPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.repository.BusDetailsRepo;
import com.aniket.portal.repository.BusDispatchRepo;
import com.aniket.portal.repository.BusRouteRepo;

@Service
public class FetchBusDetailsServiceImpl implements FetchBusDetailsSrvc {

	@Autowired
	BusDetailsRepo dtlsrepo;
	@Autowired
	BusRouteRepo routerepo;
	@Autowired
	BusDispatchRepo dispatchrepo;
	@Override
	public BusDetailsRespPojo fetchbusdetails(String busid) {
		BusDetailsRespPojo resppojo1=new BusDetailsRespPojo();
		try
		{
			Boolean result=validatebusid(busid);
			if(result==true)
			{
				Long bid = dtlsrepo.fetchuserid(busid).getId();
				BusDetailsModel obj1 = dtlsrepo.findById(bid).orElse(null);
				List<String> obj2 =routerepo.fetchlocationlist(bid);
				resppojo1.setBusdtls(obj1);	
				resppojo1.setLocationname(obj2);
			    resppojo1.setStatus("Success");
			    resppojo1.setReason("Data fetched Successfully");
			}
			else
			{
				resppojo1.setStatus("Failed");
			    resppojo1.setReason("User Name Not Found");
			}
		}
		catch(Exception e)
		{
			resppojo1.setStatus("Failed");
			resppojo1.setReason("Please Try Again Later");
		}
		return resppojo1;
	}
	@Override
	public Boolean validatebusid(String busid) {
		// TODO Auto-generated method stub
		BusDetailsModel obj1=dtlsrepo.fetchuserid(busid);
		if(obj1==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public List<BusDispatchModel> fetchuncompletedtrip(String busid) {
		// TODO Auto-generated method stub
		Long bid = dtlsrepo.fetchuserid(busid).getId();
		List<BusDispatchModel> obj3=dispatchrepo.fetchdispatch(bid);
		return obj3;
	}
	@Override
	public List<BusDispatchModel> fetchcompletedtrip(String busid) {
		// TODO Auto-generated method stub
		Long bid = dtlsrepo.fetchuserid(busid).getId();
		List<BusDispatchModel> obj3=dispatchrepo.fetchcompletedtrip(bid);
		return obj3;
	}

}