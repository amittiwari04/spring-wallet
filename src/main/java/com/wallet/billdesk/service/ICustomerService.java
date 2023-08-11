package com.wallet.billdesk.service;

import com.wallet.billdesk.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer getCustomerByAccountNumber(Integer accountNumber);
	public Customer getCustomerById(Integer id);
}
