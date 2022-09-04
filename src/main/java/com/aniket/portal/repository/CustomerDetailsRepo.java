package com.aniket.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aniket.portal.model.CustomerDetailsModel;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetailsModel,Long>{
	
	@Query(value = "select max(id) from cstmr_dtls_mstr", nativeQuery = true) 
	Long fetchmaxid();
	
	@Query(value = "select * from cstmr_dtls_mstr where Customer_Name=?1 and (Mobileno=?2 or Emailid=?3)", nativeQuery = true) 
	CustomerDetailsModel fetchexistence(String name,String no,String eid);
}