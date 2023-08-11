package com.wallet.billdesk.dto;

import java.util.ArrayList;
import java.util.List;

import com.wallet.billdesk.entity.Transaction;

public class TransactionResponseDto {

	private AccountDto account;
	private List<TransactionDto> transactionList = new ArrayList<>();
	public AccountDto getAccountDao() {
		return account;
	}
	public void setAccountDao(AccountDto accountDao) {
		this.account = accountDao;
	}
	public List<TransactionDto> getTransactionList() {
		return transactionList;
	}
	public TransactionResponseDto(AccountDto accountDao, List<TransactionDto> transactionList) {
		super();
		this.account = accountDao;
		this.transactionList = transactionList;
	}
	public TransactionResponseDto() {
		super();
	}
	public void setTransactionList(List<Transaction> transList) {
		this.transactionList.clear();
		int length=transList.size();
		for(int i=0;i<length;i++){
			Transaction trans = transList.get(i);
			TransactionDto transaction = new TransactionDto();
			transaction.setTransactionId(trans.getTransactionId());
			transaction.setModeOfPayment(trans.getModeOfPayment());
			transaction.setCreatedDate(trans.getCreatedDate());
			transaction.setModifiedDate(trans.getModifiedDate());
			transaction.setTransactionAmount(trans.getTransactionAmount());
			this.transactionList.add(transaction);
		}
	}
	
}
