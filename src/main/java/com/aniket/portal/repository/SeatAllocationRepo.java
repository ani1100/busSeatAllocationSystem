package com.aniket.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aniket.portal.model.BusDispatchModel;
import com.aniket.portal.model.SeatAllocationModel;


@Repository
public interface SeatAllocationRepo extends JpaRepository<SeatAllocationModel,Long> {
	@Query(value = "select max(id) from seat_allocation_mstr", nativeQuery = true) 
	Long fetchmaxid();
	
	@Query(value = "select distinct Seat_No from seat_allocation_mstr where Bus_Sch_Id=?1 and Location_Order_id>=?2 and Location_Order_id<?3 and Allocation='Y'", nativeQuery = true) 
	List<Integer> fetchallocatedseats1(Long schid,int ord1,int ord2);
	
	@Query(value = "select distinct Seat_No from seat_allocation_mstr where Bus_Sch_Id=?1 and Location_Order_id>?2 and Location_Order_id<=?3 and Allocation='Y'", nativeQuery = true) 
	List<Integer> fetchallocatedseats2(Long schid,int ord1,int ord2);
	
	@Transactional
	@Modifying
	@Query(value = "update seat_allocation_mstr set Allocation = 'Y',Cstmr_Dtls_Id=?5  where Bus_Sch_Id=?1 and Seat_No=?2 and Location_Order_id>=?3 and Location_Order_id<?4", nativeQuery = true) 
	void saveseat1(Long schid,int seatno,int ord1,int ord2,Long id1);
	
	@Transactional
	@Modifying
	@Query(value = "update seat_allocation_mstr set Allocation = 'Y',Cstmr_Dtls_Id=?5  where Bus_Sch_Id=?1 and Seat_No=?2 and Location_Order_id>?3 and Location_Order_id<=?4", nativeQuery = true) 
	void saveseat2(Long schid,int seatno,int ord1,int ord2,Long id1);
	
	@Query(value = "select distinct Seat_No from seat_allocation_mstr where Bus_Sch_Id=?1 and Location_Order_id>=?2 and Location_Order_id<?3 and Allocation='Y' and Seat_No=?4", nativeQuery = true) 
	List<Integer> fetchseatavailbility1(Long schid,int ord1,int ord2,int seatno);
	
	@Query(value = "select distinct Seat_No from seat_allocation_mstr where Bus_Sch_Id=?1 and Location_Order_id>?2 and Location_Order_id<=?3 and Allocation='Y' and Seat_No=?4", nativeQuery = true) 
	List<Integer> fetchseatavailbility2(Long schid,int ord1,int ord2,int seatno);
	
	@Query(value = "select * from seat_allocation_mstr where Bus_Sch_Id=?1 order by id", nativeQuery = true) 
	List<SeatAllocationModel> fetchbybusschid(Long schid);
	
	@Query(value = "select * from seat_allocation_mstr where Bus_Sch_Id=?1 and Seat_No=?2 order by id", nativeQuery = true) 
	List<SeatAllocationModel> fetchbybusschidseat(Long schid,int seatno);
	
	

}
