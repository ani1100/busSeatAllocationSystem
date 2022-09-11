package com.aniket.portal.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.aniket.portal.model.BusDetailsModel;
import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.model.CustomerDetailsModel;
import com.aniket.portal.model.SeatAllocationModel;
import com.aniket.portal.repository.BusDetailsRepo;
import com.aniket.portal.repository.BusDispatchRepo;
import com.aniket.portal.repository.BusRouteRepo;
import com.aniket.portal.repository.CustomerDetailsRepo;
import com.aniket.portal.repository.SeatAllocationRepo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class SeatpdfSrvc {
	@Autowired
	SeatAllocationRepo seatrepo;
	@Autowired
	BusDispatchRepo disrepo;
	@Autowired
	BusDetailsRepo dtlsrepo;
	@Autowired
	BusRouteRepo routerepo;
	@Autowired
	CustomerDetailsRepo cstrepo;
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public ByteArrayOutputStream pdfcontent(Long busschid)
	{
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try
		{
			Font regular = new Font(FontFamily.HELVETICA, 12);
			Font bold =  new Font(FontFamily.HELVETICA, 12, Font.BOLD);
			Document document=new Document();
			document.setPageSize(PageSize.LETTER);	
			document.addAuthor("Aniket");
			PdfWriter.getInstance(document, baos);
			document.addTitle("SeatPdfView");
			document.open();
			BusDispatchModel disobj=disrepo.getById(busschid);
			Long busobjid=disrepo.getById(busschid).getBusdtlsid();
			BusDetailsModel busdtlsobj=dtlsrepo.getById(busobjid);
			Paragraph p2=new Paragraph(busdtlsobj.getBusnumberplate());
			p2.setAlignment(Element.ALIGN_CENTER);
			document.add(p2);
			p2.clear();
			if(disobj.getFlag()==0)
			{
				p2.add(busdtlsobj.getEndpoint1().concat(" -> ").concat(busdtlsobj.getEndpoint2()));
			}
			else
			{
				p2.add(busdtlsobj.getEndpoint2().concat(" -> ").concat(busdtlsobj.getEndpoint1()));
			}
			document.add(p2);
			for(Integer i=1;i<=busdtlsobj.getSeats();i++)
			{
				Paragraph p1=new Paragraph("Seat ".concat(i.toString()).concat(":"), bold);
				document.add(p1);
				List<SeatAllocationModel> seatdtlslis=seatrepo.fetchbybusschidseat(busschid, i);
				String occupy="N";
				Long cstid=-1L;
				int ordid=-1;
				for(SeatAllocationModel seatdtlsobj:seatdtlslis)
				{
					String occ=seatdtlsobj.getAllocation();
					if(occ.equals("Y"))
					{
						if(occupy.equals("N"))
						{
							occupy="Y";
							cstid=seatdtlsobj.getCstmrdtlsid();
							ordid=seatdtlsobj.getLocationorderid();
						}
						else
						{
							if(seatdtlsobj.getCstmrdtlsid()==cstid)
							{
								continue;
							}
							else
							{
								CustomerDetailsModel cstobj=cstrepo.getById(cstid);
								String loc1=routerepo.fetchbusbyorderid(busobjid,ordid).getLocationname();
								String loc2=routerepo.fetchbusbyorderid(busobjid,seatdtlsobj.getLocationorderid()).getLocationname();
								String temp=loc1.concat(" - ").concat(loc2).concat("  ->  ").concat(cstobj.getCstmrname()).concat(" (Mobile No : ").concat(cstobj.getMobileno()).concat(")");
								Paragraph p3=new Paragraph(temp);
								document.add(p3);
								cstid=seatdtlsobj.getCstmrdtlsid();
								ordid=seatdtlsobj.getLocationorderid();
							}
						}
					}
					else
					{
						if(occupy.equals("Y"))
						{
							CustomerDetailsModel cstobj=cstrepo.getById(cstid);
							String loc1=routerepo.fetchbusbyorderid(busobjid,ordid).getLocationname();
							String loc2=routerepo.fetchbusbyorderid(busobjid,seatdtlsobj.getLocationorderid()).getLocationname();
							String temp=loc1.concat(" - ").concat(loc2).concat("  ->  ").concat(cstobj.getCstmrname()).concat(" (Mobile No : ").concat(cstobj.getMobileno()).concat(")");Paragraph p3=new Paragraph(temp);
							document.add(p3);
							occupy="N";
							cstid=seatdtlsobj.getCstmrdtlsid();
							ordid=seatdtlsobj.getLocationorderid();
						}
						else
						{
							continue;
						}
					}
				}
			}
			document.close();
			return baos;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public HttpEntity<byte[]> pdfgenerator(Long busschid)
	{
		ByteArrayOutputStream bt=new ByteArrayOutputStream();
		bt=pdfcontent(busschid);
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		Long busobjid=disrepo.getById(busschid).getBusdtlsid();
		BusDetailsModel busdtlsobj=dtlsrepo.getById(busobjid);
		String fileName=busdtlsobj.getBusnumberplate().concat("_").concat(busschid.toString()).concat(".pdf");
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileName.replace(" ","_"));
		header.setContentLength(bt.toByteArray().length);
		return new HttpEntity<byte[]>(bt.toByteArray(),header);
	}

}
