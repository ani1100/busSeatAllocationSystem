package com.aniket.portal.service;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.portal.model.BusDetailsModel;
import com.aniket.portal.model.BusRoutesModel;
import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.repository.BusDetailsRepo;
import com.aniket.portal.repository.BusRouteRepo;

@Service
public class RegistrationSrvcImpl implements RegistrationSrvc {

	@Autowired
	BusDetailsRepo regrepo;
	@Autowired
	BusRouteRepo routerepo;
	@Override
	public Boolean savebusdetails(RegistrationReqPojo regpojo) {
		Long id1=0L;
		try
		{
			BusDetailsModel regobj1=new BusDetailsModel();
			regobj1.setBusname(regpojo.getBusname());
			regobj1.setOwnername(regpojo.getOwnername());
			regobj1.setBusnumberplate(regpojo.getBusnumberplate());
			regobj1.setEmailid(regpojo.getEmailid());
			regobj1.setMobileno(regpojo.getMobileno());
			regobj1.setEndpoint1(regpojo.getEndpoint1());
			regobj1.setEndpoint2(regpojo.getEndpoint2());
			regobj1.setRows(regpojo.getRows());
			regobj1.setLastseat(regpojo.getSeatlastseat());
			regobj1.setSeatleftside(regpojo.getSeatleftside());
			regobj1.setSeatrightside(regpojo.getSeatrightside());
			regobj1.setSeats(regpojo.getSeats());
			regobj1.setEsthr(regpojo.getEsthr());
			regobj1.setEstmin(regpojo.getEstmin());
			if(regrepo.count()==0)
			{
				id1=1L;
			}
			else
			{
				id1=regrepo.fetchmaxid()+1;
			}
			regobj1.setId(id1);
			regrepo.save(regobj1);
			int size1=regpojo.getLisstoppages().size();
			for(int i=0;i<size1;i++)
			{
				BusRoutesModel routeobj=new BusRoutesModel();
				if(routerepo.count()==0)
				{
					routeobj.setId(1L);
				}
				else
				{
					routeobj.setId(routerepo.fetchmaxid()+1);
				}
				routeobj.setBusdtlsid(id1);
				routeobj.setLocationname(regpojo.getLisstoppages().get(i));
				routeobj.setOrderid(i+1);
				routerepo.save(routeobj);
			}
			return true;
		}
		catch(Exception e)
		{
			regrepo.deleteById(id1);
			routerepo.deletefailedcase(id1);
			return false;
		}
	}
	@Override
	public RegistrationRespPojo registersinglebusdetails(RegistrationReqPojo regpojo) {
		// TODO Auto-generated method stub
		RegistrationRespPojo resppojo1=new RegistrationRespPojo();
		if(regrepo.fetchuserid(regpojo.getBusnumberplate())==null)
		{
			Boolean result=savebusdetails(regpojo);
			if(result==true)
			{
				resppojo1.setStatus("Success");
				resppojo1.setMessage("Bus Registered with username "+regpojo.getBusnumberplate());
			}
			else
			{
				resppojo1.setStatus("Failed");
				resppojo1.setMessage("Bus Registration Failed.Please try again later");
			}
		}
		else
		{
			resppojo1.setStatus("Failed");
			resppojo1.setMessage("Username Already Exists");
		}
		return resppojo1;
	}
	@Override
	public RegistrationRespPojo checkusername(String username) {
		// TODO Auto-generated method stub
		RegistrationRespPojo resppojo1=new RegistrationRespPojo();
		if(regrepo.fetchuserid(username)==null)
		{
			resppojo1.setStatus("Success");
			resppojo1.setMessage("Valid UserID");
		}
		else
		{
			resppojo1.setStatus("Failed");
			resppojo1.setMessage("Username Already Exists");
		}
		return resppojo1;
	}
}