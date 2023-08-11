package com.wallet.billdesk.service;

import java.util.List;

import com.wallet.billdesk.dto.TransactionResponseDto;
import com.wallet.billdesk.entity.Transaction;

public interface ITransactionService {

	public Transaction getTransactionByTransactionId(String transactionId);
	
	public TransactionResponseDto getAllTransactions(Integer accountNumber);
}
