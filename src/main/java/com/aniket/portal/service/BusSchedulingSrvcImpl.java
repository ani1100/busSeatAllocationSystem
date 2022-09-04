package com.aniket.portal.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.model.SeatAllocationModel;
import com.aniket.portal.pojos.BusSchedulingReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.repository.BusDispatchRepo;
import com.aniket.portal.repository.SeatAllocationRepo;

@Service
public class BusSchedulingSrvcImpl implements BusSchedulingSrvc {

	@Autowired
	BusDispatchRepo dispatchrepo;
	@Autowired
	SeatAllocationRepo seatallrepo;
	@Override
	public Boolean schedulebus(BusSchedulingReqPojo schbusreqpojo) {
		try
		{
			BusDispatchModel dispatchobj1=new BusDispatchModel();
			dispatchobj1.setArrivaltime(schbusreqpojo.getArrtime());
			dispatchobj1.setDeptime(schbusreqpojo.getDeptime());
			dispatchobj1.setBusdtlsid(schbusreqpojo.getBusdetails().getId());
			dispatchobj1.setFlag(schbusreqpojo.getFlag());
			dispatchobj1.setTripcompleted("N");
			Long id1;
			if(dispatchrepo.count()==0)
			{
				dispatchobj1.setId(1L);
				id1=1L;
			}
			else
			{
				id1=dispatchrepo.fetchmaxid()+1;
				dispatchobj1.setId(id1);
			}
			dispatchrepo.save(dispatchobj1);
			int nseats=schbusreqpojo.getBusdetails().getSeats();
			List<String> loc;
			int start;
			int flag1;
			if(schbusreqpojo.getFlag()==0)
			{
				loc=schbusreqpojo.getLocationname();
				start=1;
				flag1=1;
			}
			else
			{
				loc=schbusreqpojo.getLocationname();
				Collections.reverse(loc);
				start=loc.size();
				flag1=-1;
			}
			for(int i=1;i<=nseats;i++)
			{
				int startid=start;
				for(String locobj:loc)
				{
					SeatAllocationModel seatobj=new SeatAllocationModel();
					seatobj.setBusdtlsid(schbusreqpojo.getBusdetails().getId());
					seatobj.setBusschid(id1);
					seatobj.setAllocation("N");
					seatobj.setLocationorderid(startid);
					seatobj.setSeatno(i);
					if(seatallrepo.count()==0)
					{
						seatobj.setId(1L);
					}
					else
					{
						seatobj.setId(seatallrepo.fetchmaxid()+1);
					}
					seatallrepo.save(seatobj);
					startid+=flag1;
				}
				
			}
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	@Override
	public RegistrationRespPojo schedulebusrequest(BusSchedulingReqPojo schbusreqpojo) {
		RegistrationRespPojo resppojo1=new RegistrationRespPojo();
		try
		{
		List<BusDispatchModel>lisobj= dispatchrepo.fetchdistinctsch(schbusreqpojo.getDeptime(),schbusreqpojo.getArrtime(),schbusreqpojo.getBusdetails().getId());
		if(lisobj.size()==0)
		{
				int flag1=0;
				int flagquery1;
				int flagquery2;
				if(schbusreqpojo.getFlag()==0)
				{
					flagquery1=1;
					flagquery2=0;
				}
				else
				{
					flagquery1=0;
					flagquery2=1;
				}
				SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date datear=formatter1.parse(schbusreqpojo.getArrtime());
				Date datedp=formatter1.parse(schbusreqpojo.getDeptime());
				List<BusDispatchModel> objdeplis=dispatchrepo.fetchbusbydep(schbusreqpojo.getDeptime(),flagquery1,schbusreqpojo.getBusdetails().getId());
				if(objdeplis.size()>0)
				{
					BusDispatchModel objdep1=objdeplis.get(0);
					Calendar caldep = Calendar.getInstance();
				    caldep.setTime(datedp);
				    caldep.add(Calendar.HOUR_OF_DAY, -2);
				    Date date = caldep.getTime();
				    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    String date1 = format1.format(date);
				    String date2=format1.format(formatter1.parse(objdep1.getArrivaltime()));
				    if(date2.compareTo(date1)>0)
				    {
				    	flag1=1;
				    }
				}
				objdeplis=dispatchrepo.fetchbusbydep(schbusreqpojo.getDeptime(),flagquery2,schbusreqpojo.getBusdetails().getId());
				if(objdeplis.size()>0)
				{
					BusDispatchModel objdep1=objdeplis.get(0);
					Calendar caldep = Calendar.getInstance();
				    caldep.setTime(datedp);
				    caldep.add(Calendar.HOUR_OF_DAY, -2);
				    caldep.add(Calendar.HOUR_OF_DAY, -schbusreqpojo.getBusdetails().getEsthr());
				    caldep.add(Calendar.MINUTE,-schbusreqpojo.getBusdetails().getEstmin());
				    Date date = caldep.getTime();
				    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    String date1 = format1.format(date);
				    String date2=format1.format(formatter1.parse(objdep1.getArrivaltime()));
				    if(date2.compareTo(date1)>0)
				    {
				    	flag1=1;
				    }
				}
				objdeplis=dispatchrepo.fetchbusbyarr(schbusreqpojo.getArrtime(),flagquery2,schbusreqpojo.getBusdetails().getId());
				if(objdeplis.size()>0)
				{
					BusDispatchModel objdep1=objdeplis.get(0);
					Calendar caldep = Calendar.getInstance();
				    caldep.setTime(datear);
				    caldep.add(Calendar.HOUR_OF_DAY, 2);
				    caldep.add(Calendar.HOUR_OF_DAY, schbusreqpojo.getBusdetails().getEsthr());
				    caldep.add(Calendar.MINUTE,schbusreqpojo.getBusdetails().getEstmin());
				    Date date = caldep.getTime();
				    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    String date1 = format1.format(date);
				    String date2=format1.format(formatter1.parse(objdep1.getDeptime()));
				    if(date2.compareTo(date1)<0)
				    {
				    	flag1=1;
				    }
				}
				objdeplis=dispatchrepo.fetchbusbyarr(schbusreqpojo.getArrtime(),flagquery1,schbusreqpojo.getBusdetails().getId());
				if(objdeplis.size()>0)
				{
					BusDispatchModel objdep1=objdeplis.get(0);
					Calendar caldep = Calendar.getInstance();
				    caldep.setTime(datear);
				    caldep.add(Calendar.HOUR_OF_DAY, 2);
				    Date date = caldep.getTime();
				    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    String date1 = format1.format(date);
				    String date2=format1.format(formatter1.parse(objdep1.getDeptime()));
				    if(date2.compareTo(date1)<0)
				    {
				    	flag1=1;
				    }
				}
			if(flag1==1)
			{
				resppojo1.setStatus("Failed");
				resppojo1.setMessage("Buffer Time Overlapping");
				
			}
			else
			{
				Boolean result = schedulebus(schbusreqpojo);
				if(result==true)
				{
					resppojo1.setStatus("Success");
					resppojo1.setMessage("Bus scheduled successfully");
				}
				else
				{
					resppojo1.setStatus("Failed");
					resppojo1.setMessage("Bus Scheduling Failed.Please try again later");
				}
			}
		}
		else
		{
			resppojo1.setStatus("Failed");
			resppojo1.setMessage("Bus Already Scheduled for this time");
		}
	}
	catch(Exception e)
	{
		resppojo1.setStatus("Failed");
		resppojo1.setMessage("Exception Occured");
		System.out.println(e);
	}
		return resppojo1;
	}
	
	

}