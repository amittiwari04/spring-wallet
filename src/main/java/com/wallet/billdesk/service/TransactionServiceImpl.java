package com.wallet.billdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.billdesk.dao.IAccountDao;
import com.wallet.billdesk.dao.ITransactionDao;
import com.wallet.billdesk.dto.AccountDto;
import com.wallet.billdesk.dto.TransactionResponseDto;
import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Transaction;

@Service
public class TransactionServiceImpl implements ITransactionService {	
	@Autowired
	private ITransactionDao dao;
	
	@Autowired
	private IAccountDao accountDao;

	@Override
	public Transaction getTransactionByTransactionId(String transactionId) {
		return dao.getTransactionByTransactionId(transactionId);
	}
	
	@Override
	public TransactionResponseDto getAllTransactions(Integer accountNumber) {
		Account account = accountDao.getAccountByAccountNumber(accountNumber);
		Integer account_id = account.getId();
		List<Transaction> listOfTransaction =  dao.getAllTransactionsByAccountId(account_id);
		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
		AccountDto accountDto = createAccountDto(account);
		transactionResponseDto.setAccountDao(accountDto);
		transactionResponseDto.setTransactionList(listOfTransaction);
		return transactionResponseDto;
		
	}
	public AccountDto createAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountBalance(account.getAccountBalance());
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setCreatedAt(account.getCreatedAt());
		accountDto.setUpdatedAt(account.getUpdatedAt());
		return accountDto;
	}
}
