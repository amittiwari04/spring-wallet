package com.wallet.billdesk.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Customer;
import com.wallet.billdesk.service.IAccountService;
import com.wallet.billdesk.service.ICustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController implements Serializable{
	@Autowired
	private ICustomerService service;
//	
//	@Autowired
//    private ModelMapper modelMapper;
	
	@PostMapping(value="/create")
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer){
//		Customer cust= convertToEntity(customerResponseDto);
		Customer c1=service.addCustomer(customer);
		return new ResponseEntity<Customer>(c1,HttpStatus.CREATED);
	}
	

	@GetMapping(value="/get")
	public ResponseEntity<Customer> getCustomerByAccountNumber(@RequestBody Account account){
		Integer accountNumber = account.getAccountNumber();
		Customer cust=service.getCustomerByAccountNumber(accountNumber);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
//	@GetMapping(value="/get/{id}")
//	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id){
//		Customer cust=service.getCustomerById(id);
//		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
//	}
	
}
