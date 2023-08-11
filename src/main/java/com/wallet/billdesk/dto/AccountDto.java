package com.wallet.billdesk.dto;

import java.util.Calendar;

public class AccountDto {
	private Integer accountNumber;
	private Integer accountBalance;
	private Calendar createdAt;
	private Calendar updatedAt;
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getAccountBalance() {
		return accountBalance;
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
	public AccountDto(Integer accountNumber, Integer accountBalance, Calendar createdAt, Calendar updatedAt) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
