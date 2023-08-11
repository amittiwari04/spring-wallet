package com.wallet.billdesk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wallet.billdesk.entity.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>{

	@Query(value="select * from customer_details where account_id=:accountId",nativeQuery = true)
	Customer getCustomerById(@Param("accountId") Integer accountNumber);
}
