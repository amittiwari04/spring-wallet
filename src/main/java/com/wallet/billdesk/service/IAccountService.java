package com.wallet.billdesk.service;

import java.util.List;

import com.wallet.billdesk.dto.AccountResponseDto;
import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Customer;
import com.wallet.billdesk.entity.Transaction;

public interface IAccountService {
	public Account addAccount(Account account);
	
	public AccountResponseDto updateAccount(Account account,Integer accountNumber);

}