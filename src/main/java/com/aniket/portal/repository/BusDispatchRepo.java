package com.aniket.portal.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aniket.portal.model.BusDispatchModel;

@Repository
public interface BusDispatchRepo extends JpaRepository<BusDispatchModel,Long> {
    
	@Query(value = "select max(id) from bus_dispatch_mstr", nativeQuery = true) 
	Long fetchmaxid();
	
	@Query(value = "select * from bus_dispatch_mstr where Bus_Dtls_Id=?1 and Trip_Completed = 'Y' order by DEPARTURE_TIME", nativeQuery = true) 
	List<BusDispatchModel> fetchcompletedtrip(Long id);
	
	@Query(value = "select * from bus_dispatch_mstr where Bus_Dtls_Id=?1 and Trip_Completed <> 'Y' order by DEPARTURE_TIME", nativeQuery = true) 
	List<BusDispatchModel> fetchdispatch(Long id);
	
	@Query(value = "select * from BUS_DISPATCH_MSTR a where a.DEPARTURE_TIME like ?1 and a.DEPARTURE_TIME > ?2", nativeQuery = true) 
	List<BusDispatchModel> fetchbus(String date1,String time1);
	
	@Query(value = "select * from BUS_DISPATCH_MSTR a where a.Arrival_Time < ?1 and a.Bus_Dtls_Id=?3 and a.Flag=?2 order by a.Arrival_Time DESC", nativeQuery = true) 
	List<BusDispatchModel> fetchbusbydep(String deptime,int flag,Long busid);
	
	@Query(value = "select * from BUS_DISPATCH_MSTR a where a.DEPARTURE_TIME > ?1 and a.Bus_Dtls_Id=?3 and a.Flag=?2 order by a.DEPARTURE_TIME ASC", nativeQuery = true) 
	List<BusDispatchModel> fetchbusbyarr(String arrtime,int flag,Long busid);
	
	@Query(value = "select * from BUS_DISPATCH_MSTR a where Bus_Dtls_Id=?3 and ((a.DEPARTURE_TIME >= ?1 and a.Arrival_Time<=?2) or (a.DEPARTURE_TIME <= ?1 and a.Arrival_Time>=?2) or (a.Arrival_Time >= ?2 and a.DEPARTURE_TIME<=?2) or (a.Arrival_Time >= ?1 and a.DEPARTURE_TIME<= ?1))", nativeQuery = true) 
	List<BusDispatchModel> fetchdistinctsch(String deptime,String arrtime,Long busid);
	
	@Transactional
	@Modifying
	@Query(value = "update bus_dispatch_mstr set Trip_Completed='Y' where Arrival_Time<=?1 and Trip_Completed='H'", nativeQuery = true) 
	void autocompletion(String dt);
	
	@Transactional
	@Modifying
	@Query(value = "update bus_dispatch_mstr set Trip_Completed='H' where DEPARTURE_TIME<=?1 and Trip_Completed='N'", nativeQuery = true) 
	void autostart(String dt);
}