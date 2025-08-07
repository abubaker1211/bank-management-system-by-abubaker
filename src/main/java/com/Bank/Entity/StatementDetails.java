package com.Bank.Entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class StatementDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String transationtype;
	@Column(nullable=false)
	private double transactionamount;
	@Column(nullable=false)
	private Time timeoftransaction;
	@Column(nullable=false)
	private Date dateoftransaction;
	@Column(nullable=false)
	private double balanceamount;
	@Column(nullable=false)
	private Integer userid;
	public StatementDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatementDetails(Integer id, String transationtype, double transactionamount, Time timeoftransaction,
			Date dateoftransaction, double balanceamount, Integer userid) {
		super();
		this.id = id;
		this.transationtype = transationtype;
		this.transactionamount = transactionamount;
		this.timeoftransaction = timeoftransaction;
		this.dateoftransaction = dateoftransaction;
		this.balanceamount = balanceamount;
		this.userid = userid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTransationtype() {
		return transationtype;
	}
	public void setTransationtype(String transationtype) {
		this.transationtype = transationtype;
	}
	public double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}
	public Time getTimeoftransaction() {
		return timeoftransaction;
	}
	public void setTimeoftransaction(Time timeoftransaction) {
		this.timeoftransaction = timeoftransaction;
	}
	public Date getDateoftransaction() {
		return dateoftransaction;
	}
	public void setDateoftransaction(Date dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public double getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "StatementDetails [id=" + id + ", transationtype=" + transationtype + ", transactionamount="
				+ transactionamount + ", timeoftransaction=" + timeoftransaction + ", dateoftransaction="
				+ dateoftransaction + ", balanceamount=" + balanceamount + ", userid=" + userid + "]";
	}
	
	
}
