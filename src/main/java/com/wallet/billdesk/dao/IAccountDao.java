package com.wallet.billdesk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Transaction;

@Repository
public interface IAccountDao extends JpaRepository<Account, Integer>{

	//Account findbyAccountNumber(Integer accountNumber);

	@Query(value="select * from account where account_number=:accountNumber",nativeQuery = true)
	public Account getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

	//public Account findbyAccountNumber(Integer accountNumber);
	
}
