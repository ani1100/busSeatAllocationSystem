package com.aniket.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.portal.model.BusDetailsModel;
import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.model.BusRoutesModel;
import com.aniket.portal.model.CustomerDetailsModel;
import com.aniket.portal.model.SeatAllocationModel;
import com.aniket.portal.pojos.AllocationReqPojo;
import com.aniket.portal.pojos.BusSeatPojo;
import com.aniket.portal.pojos.CustomerBookingReqPojo;
import com.aniket.portal.pojos.CustomerBookingResp;
import com.aniket.portal.pojos.CustomerBusSeatResp;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.repository.BusDetailsRepo;
import com.aniket.portal.repository.BusDispatchRepo;
import com.aniket.portal.repository.BusRouteRepo;
import com.aniket.portal.repository.CustomerDetailsRepo;
import com.aniket.portal.repository.SeatAllocationRepo;

@Service
public class SeatBookingSrvcImpl implements SeatBookingSrvc{

	@Autowired
	BusDispatchRepo busdispatchrepo;
	
	@Autowired
	SeatAllocationRepo seatallrepo;
	
	@Autowired
	BusRouteRepo routerepo;
	
	@Autowired
	BusDetailsRepo dtlsrepo;
	
	@Autowired
	CustomerDetailsRepo custrepo;
	
	@Override
	public List<CustomerBookingResp> customerseatbooking(CustomerBookingReqPojo reqpojo) {
		List<CustomerBookingResp> buslist=new ArrayList<CustomerBookingResp>();
		String deptime=reqpojo.getDeptime();
		String depdate=deptime.split(" ")[0].concat("%");
		List<BusDispatchModel> buslistday=busdispatchrepo.fetchbus(depdate,deptime);
		for(BusDispatchModel busobj:buslistday)
		{
			try
			{
				CustomerBookingResp busresp=new CustomerBookingResp();
				BusRoutesModel obj1=routerepo.fetchbusbyloc(busobj.getBusdtlsid(), reqpojo.getStartloc());
				BusRoutesModel obj2=routerepo.fetchbusbyloc(busobj.getBusdtlsid(), reqpojo.getEndloc());
				if(obj1==null||obj2==null)
				{
					continue;
				}
				if(busobj.getFlag()==0 && obj2.getOrderid()>obj1.getOrderid())
				{
						BusDetailsModel busdtls1=dtlsrepo.findById(busobj.getBusdtlsid()).orElse(null);
						if(dtlsrepo.findById(busobj.getBusdtlsid())!=null)
						{
							busresp.setBusdetails(busdtls1);
						}
						else
						{
							continue;
						}
						busresp.setScheduledbus(busobj);
						busresp.setExpansion(false);
						busresp.setStartpoint(busdtls1.getEndpoint1());
						busresp.setEndpoint(busdtls1.getEndpoint2());
						busresp.setDeptime(busobj.getDeptime().split(" ")[1]);
						busresp.setArrtime(busobj.getArrivaltime().split(" ")[1]);
						busresp.setCustendloc(reqpojo.getEndloc());
						busresp.setCuststartloc(reqpojo.getStartloc());
						busresp.setCustdeptime(reqpojo.getDeptime());
						buslist.add(busresp);
				}
				else if(busobj.getFlag()==1 && obj1.getOrderid()>obj2.getOrderid())
				{
						BusDetailsModel busdtls1=dtlsrepo.findById(busobj.getBusdtlsid()).orElse(null);
						if(dtlsrepo.findById(busobj.getBusdtlsid())!=null)
						{
							busresp.setBusdetails(busdtls1);
						}
						else
						{
							continue;
						}
						busresp.setScheduledbus(busobj);
						busresp.setExpansion(false);		
						busresp.setStartpoint(busdtls1.getEndpoint2());
						busresp.setEndpoint(busdtls1.getEndpoint1());
						busresp.setDeptime(busobj.getDeptime().split(" ")[1]);
						busresp.setArrtime(busobj.getArrivaltime().split(" ")[1]);
						busresp.setCustendloc(reqpojo.getEndloc());
						busresp.setCuststartloc(reqpojo.getStartloc());
						busresp.setCustdeptime(reqpojo.getDeptime());
						buslist.add(busresp);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}	
		}
		List<CustomerBookingResp> listpojo1=buslist.stream().sorted(Comparator.comparing(CustomerBookingResp::getDeptime).thenComparing(CustomerBookingResp::getArrtime)).collect(Collectors.toList()); //Sorted UI display
        return listpojo1;
	}
	@SuppressWarnings("deprecation")
	@Override
	public CustomerBusSeatResp fetchbusseatdetails(CustomerBookingResp reqpojo) {
		// TODO Auto-generated method stub
		CustomerBusSeatResp resp=new CustomerBusSeatResp();
		try
		{
			if(busdispatchrepo.getById(reqpojo.getScheduledbus().getId()).getTripcompleted().equals("N"))
			{
				List<Integer> allocateseats=new ArrayList<Integer>();
				List<BusSeatPojo> seatlist= new ArrayList<BusSeatPojo>();
				int ord1=routerepo.fetchbusbyloc(reqpojo.getBusdetails().getId(),reqpojo.getCuststartloc()).getOrderid();
				int ord2=routerepo.fetchbusbyloc(reqpojo.getBusdetails().getId(),reqpojo.getCustendloc()).getOrderid();
				if(ord1>ord2)//Reversed
				{
					int temp=ord1;
					ord2=ord1;
					ord1=temp;
				}
				if(reqpojo.getScheduledbus().getFlag()==0)
				{
				allocateseats= seatallrepo.fetchallocatedseats1(reqpojo.getScheduledbus().getId(), ord1, ord2);
				}
				else
				{
				allocateseats= seatallrepo.fetchallocatedseats2(reqpojo.getScheduledbus().getId(), ord1, ord2);	
				}
				for(int i=reqpojo.getBusdetails().getSeats();i>=1;i=i-1)
				{
					BusSeatPojo seatpojo=new BusSeatPojo();
					if(allocateseats.contains(i)==true)
					{
						seatpojo.setSeatno(i);
						seatpojo.setStatus("Y");
					}
					else
					{
						seatpojo.setSeatno(i);
						seatpojo.setStatus("N");
					}
					seatlist.add(seatpojo);
				}
				resp.setCustbook(reqpojo);
				resp.setListseat(seatlist);
				resp.setStatus("Success");
				resp.setReason("Fetched Details");
				return resp;
			}
			else
			{
				resp.setStatus("Failed");
				resp.setReason("Bus has departed");
				return resp;
			}
		}
		catch(Exception e)
		{
			resp.setStatus("Failed");
			resp.setReason("Error in fetching data");
			return resp;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public RegistrationRespPojo allocateseats(AllocationReqPojo reqpojo) {
		// TODO Auto-generated method stub
		RegistrationRespPojo resppojo=new RegistrationRespPojo();
		try
		{
			if(busdispatchrepo.getById(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getId()).getTripcompleted().equals("N"))
			{
				int ord1=routerepo.fetchbusbyloc(reqpojo.getBusseatresp().getCustbook().getBusdetails().getId(),reqpojo.getBusseatresp().getCustbook().getCuststartloc()).getOrderid();
				int ord2=routerepo.fetchbusbyloc(reqpojo.getBusseatresp().getCustbook().getBusdetails().getId(),reqpojo.getBusseatresp().getCustbook().getCustendloc()).getOrderid();
				if(ord1>ord2)
				{
					int temp=ord1;
					ord2=ord1;
					ord1=temp;
				}
				List<String> lisresp=new ArrayList<String>();
				List<String> lis=new ArrayList<String>();
				for(Integer seat:reqpojo.getSeatnos())
				{
					lisresp.add(seat.toString());
					if(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getFlag()==0)
					{
						if(seatallrepo.fetchseatavailbility1(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getId(),ord1,ord2,seat).size()>0)
						{
							lis.add(seat.toString());
						}
					}
					else
					{
						if(seatallrepo.fetchseatavailbility2(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getId(),ord1,ord2,seat).size()>0)
						{
							lis.add(seat.toString());
						}
					}
				}
				if(lis.size()>0)
				{
					resppojo.setStatus("Failed");
					resppojo.setMessage("Seat No - ".concat(String.join(",",lis)).concat(" already occupied. Booking Failed."));
					return resppojo;
				}
				CustomerDetailsModel cstdtls=new CustomerDetailsModel();
		        CustomerDetailsModel custobj=custrepo.fetchexistence(reqpojo.getCustdtls().getCstmrname(),reqpojo.getCustdtls().getMobileno(),reqpojo.getCustdtls().getEmailid());
				Long id1;
				if(custobj==null)
				{
					cstdtls.setCstmrname(reqpojo.getCustdtls().getCstmrname());
					cstdtls.setEmailid(reqpojo.getCustdtls().getEmailid());
					cstdtls.setMobileno(reqpojo.getCustdtls().getMobileno());
					if(custrepo.count()==0)
					{
						id1=1L;
						cstdtls.setId(id1);
						custrepo.save(cstdtls);
					}
					else
					{
						id1=custrepo.fetchmaxid()+1;
						cstdtls.setId(id1);
						custrepo.save(cstdtls);
					}
				}
				else
				{
					id1=custobj.getId();
				}
				for(Integer seat:reqpojo.getSeatnos())
				{
					if(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getFlag()==0)
					{	
					seatallrepo.saveseat1(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getId(), seat, ord1, ord2, id1);
					}
					else
					{
					seatallrepo.saveseat2(reqpojo.getBusseatresp().getCustbook().getScheduledbus().getId(), seat, ord1, ord2, id1);	
					}
				}
				resppojo.setStatus("Success");
				resppojo.setMessage("Seat No - ".concat(String.join(",",lisresp)).concat(" booked"));
				return resppojo;
			}
			else
			{
				resppojo.setStatus("Failed");
				resppojo.setMessage("Bus has departed");
				return resppojo;
			}
		
	}
	catch(Exception e)
	{
		resppojo.setStatus("Failed");
		resppojo.setMessage("Error in  saving data");
		return resppojo;
	}

  }
}