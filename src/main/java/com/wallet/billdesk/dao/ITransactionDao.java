package com.wallet.billdesk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Transaction;

@Repository
public interface ITransactionDao  extends JpaRepository<Transaction, String>{

	@Query(value="select * from transaction_details where transaction_id=:transactionId",nativeQuery = true)
	public Transaction getTransactionByTransactionId(@Param("transactionId") String transactionId);
	
	@Query(value="select * from transaction_details where account_id=:accountId",nativeQuery = true)
	public List<Transaction> getAllTransactionsByAccountId(@Param("accountId") Integer accountId);

}
