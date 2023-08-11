package com.wallet.billdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.billdesk.dto.TransactionResponseDto;
import com.wallet.billdesk.entity.Customer;
import com.wallet.billdesk.entity.Transaction;
import com.wallet.billdesk.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private ITransactionService service;

	@GetMapping(value="/get/{transactionId}")
	public ResponseEntity<Transaction> getCustomerByAccountNumber(@PathVariable("transactionId") String transactionId){
		Transaction trans=service.getTransactionByTransactionId(transactionId);
		return new ResponseEntity<Transaction>(trans,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllTransactions/{accountNumber}")
	public ResponseEntity<TransactionResponseDto> getAllTransactions(@PathVariable("accountNumber") Integer accountNumber){
		TransactionResponseDto listOfTransactions=service.getAllTransactions(accountNumber);
		return new ResponseEntity<TransactionResponseDto>(listOfTransactions,HttpStatus.CREATED);
	}
}
