package com.wallet.billdesk.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.billdesk.dao.IAccountDao;
import com.wallet.billdesk.dao.ICustomerDao;
import com.wallet.billdesk.entity.Account;
import com.wallet.billdesk.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private IAccountDao accountDao;
	
	public Integer generateUniqueAccountNumber() {
		Integer accountNumber = (int) System.currentTimeMillis();
		String strAccountNumber = String.valueOf(accountNumber);
		String strAccountNumberOfLength12 = strAccountNumber.substring(0,7);
		return Integer.parseInt(strAccountNumberOfLength12);
	}
	
	public String getTodayDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		String todayDate = currentDate.format(formatter);
		return todayDate;
	}
	

	@Override
	public Customer addCustomer(Customer customer) {
		Integer accountNumber = generateUniqueAccountNumber();
		System.out.println("account number is : "+accountNumber);
		
		Account account = new Account();
		account.setAccountBalance(0);
		account.setAccountNumber(accountNumber);
		
		//saving the details in the account
		accountDao.save(account);
		System.out.println("dao called");
		//adding the account in the customer (foreign key)
		customer.setAccount(account);
		
		Customer savedCustomer = customerDao.save(customer);

		return savedCustomer;
	}

	@Override
	public Customer getCustomerByAccountNumber(Integer accountNumber) {
		Account account = accountDao.getAccountByAccountNumber(accountNumber);
		System.out.println(account);
	    Customer cust = customerDao.getCustomerById(account.getId());
	    return cust;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Customer cust =customerDao.findById(id).orElse(new Customer());
		System.out.println(cust.getFirstName());
		return cust;
	}

}
