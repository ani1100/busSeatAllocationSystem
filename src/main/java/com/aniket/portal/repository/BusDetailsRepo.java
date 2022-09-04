package com.aniket.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aniket.portal.model.BusDetailsModel;

@Repository
public interface BusDetailsRepo extends JpaRepository<BusDetailsModel,Long> {
	@Query(value = "select max(id) from bus_dtls_mstr", nativeQuery = true) 
	Long fetchmaxid();
	
	@Query(value = "select * from bus_dtls_mstr where Bus_Number_Plate=?1", nativeQuery = true) 
	BusDetailsModel fetchuserid(String busid);

}