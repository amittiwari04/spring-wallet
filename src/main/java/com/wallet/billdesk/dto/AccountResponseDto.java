package com.wallet.billdesk.dto;

import java.util.Calendar;

public class AccountResponseDto {
	
	private Integer accountBalance;
	private String transactionId;
	
	public AccountResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	private Calendar createdAt;
	private Calendar updatedAt;
	public Integer getAccountBalance() {
		return accountBalance;
	}
	
	

	public AccountResponseDto(Integer accountBalance, String transactionId, Calendar createdAt, Calendar updatedAt) {
		super();
		this.accountBalance = accountBalance;
		this.transactionId = transactionId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
//	private String mode;
//	private String description;
	
}
