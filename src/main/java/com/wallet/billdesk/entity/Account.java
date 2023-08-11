package com.wallet.billdesk.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Account")
public class Account implements Externalizable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private Integer accountNumber;
	private Integer accountBalance = 0;

	@JsonIgnore
	@OneToOne(mappedBy = "account")
	private Customer customer;

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", customer=" + customer + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", transactionList=" + transactionList + "]";
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Calendar createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt")
	private Calendar updatedAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<Transaction> transactionList = new ArrayList<>();

	public Integer getId() {
		return id;
	}
	
	public void addTransaction(Transaction trans) {
		transactionList.add(trans);
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public Account(Integer id, Integer accountNumber, Integer accountBalance, Customer customer, Calendar createdAt,
			Calendar updatedAt) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.customer = customer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Account() {
		super();
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
