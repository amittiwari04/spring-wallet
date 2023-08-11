package com.wallet.billdesk.controller;



import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.billdesk.dto.AccountResponseDto;
import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Transaction;
import com.wallet.billdesk.service.IAccountService;


@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	
	
	@Autowired
	private IAccountService service;
	
	@PutMapping(value="/deposit")
	public ResponseEntity<AccountResponseDto> editAccount(@RequestBody Account account) throws ParseException{
		
		Integer accountNumber = account.getAccountNumber();
		AccountResponseDto a1=service.updateAccount(account, accountNumber);
		return new ResponseEntity<AccountResponseDto>(a1,HttpStatus.CREATED);
	}
	
}
	
	
