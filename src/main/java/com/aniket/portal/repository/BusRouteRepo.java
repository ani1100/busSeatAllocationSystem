package com.aniket.portal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.aniket.portal.model.BusRoutesModel;

@Repository
public interface BusRouteRepo extends JpaRepository<BusRoutesModel,Long> {
	@Query(value = "select max(id) from bus_route_mstr", nativeQuery = true) 
	Long fetchmaxid();
	
	@Query(value = "delete from bus_route_mstr where Bus_Dtls_Id=?1", nativeQuery = true) 
	void deletefailedcase(Long id1);
	
	@Query(value = "select Location_Name from bus_route_mstr where Bus_Dtls_Id=?1 order by Order_Id", nativeQuery = true) 
	List<String> fetchlocationlist(Long id1);
	
	@Query(value = "select * from bus_route_mstr where Bus_Dtls_Id=?1 and LOCATION_NAME=?2", nativeQuery = true) 
	BusRoutesModel fetchbusbyloc(Long id,String loc1);
	
	@Query(value = "select * from bus_route_mstr where Bus_Dtls_Id=?1 and Order_Id=?2", nativeQuery = true) 
	BusRoutesModel fetchbusbyorderid(Long id,int ord);

}