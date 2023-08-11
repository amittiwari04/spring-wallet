package com.wallet.billdesk.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.billdesk.dao.IAccountDao;
import com.wallet.billdesk.dao.ITransactionDao;
import com.wallet.billdesk.dto.AccountResponseDto;
import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Transaction;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	IAccountDao dao;
	
	@Autowired
	ITransactionDao transactionDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Account addAccount(Account account) {
		return dao.save(account);
	}

	@Override
	public AccountResponseDto updateAccount(Account account, Integer accountNumber) {
		Account acc = dao.getAccountByAccountNumber(accountNumber);
		Integer oldBalance = acc.getAccountBalance();
		Integer addedAmount = account.getAccountBalance();
		Integer newBalance = oldBalance + addedAmount;
		acc.setAccountBalance(newBalance);
		
		Transaction trans = new Transaction();
		trans.setModeOfPayment("Upi");
		String uniqueTransactionId = generateUniqueTransactionId();
		System.out.println("transaction id is "+uniqueTransactionId);
		trans.setTransactionId(uniqueTransactionId);
		trans.setTransactionAmount(addedAmount);
		trans.setAccount(acc);
		acc.addTransaction(trans);
		transactionDao.save(trans);
		AccountResponseDto aDto = convertToDto(acc);
		aDto.setTransactionId(uniqueTransactionId);
		dao.save(acc);
		return aDto;
	}
	
	private AccountResponseDto convertToDto(Account account) {
	    AccountResponseDto accountResponseDto = modelMapper.map(account, AccountResponseDto.class);
	    return accountResponseDto;
	}
	
	public String generateUniqueTransactionId() {
		Integer accountNumber = (int) System.currentTimeMillis();
		String strAccountNumber = getTodayDate()+String.valueOf(accountNumber);
		return "TXN"+strAccountNumber;
	}
	
	public String getTodayDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		String todayDate = currentDate.format(formatter);
		return todayDate;
	}
}
