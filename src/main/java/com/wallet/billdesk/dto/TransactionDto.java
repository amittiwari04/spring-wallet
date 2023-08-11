package com.wallet.billdesk.dto;

import java.util.Calendar;

public class TransactionDto {

    private String transactionId;
    private Calendar createdDate;
    private Calendar modifiedDate;
    private String modeOfPayment;
    private long transactionAmount;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Calendar getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	public Calendar getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public TransactionDto() {
		super();
	}
	public TransactionDto(String transactionId, Calendar createdDate, Calendar modifiedDate, String modeOfPayment,
			long transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modeOfPayment = modeOfPayment;
		this.transactionAmount = transactionAmount;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
    
    
}
