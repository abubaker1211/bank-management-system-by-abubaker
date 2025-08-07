package com.Bank.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankUserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String emailid;
	@Column(nullable=false,unique=true)
	private long aadhaarnumber;
	@Column(nullable=false,unique=true)
	private long mobilenumber;
	@Column(nullable=false)
	private String pannumber;
	@Column(unique=true)
	private Integer pin;
	@Column(unique=true)
	private Long accountnumber;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String gender;
	@Column(nullable=false)
	private double amount;
	@Column(nullable=false)
	private String status;
	public BankUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankUserDetails(Integer id, String name, String emailid, long aadhaarnumber, long mobilenumber,
			String pannumber, int pin, long accountnumber, String address, String gender, double amount,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.aadhaarnumber = aadhaarnumber;
		this.mobilenumber = mobilenumber;
		this.pannumber = pannumber;
		this.pin = pin;
		this.accountnumber = accountnumber;
		this.address = address;
		this.gender = gender;
		this.amount = amount;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getAadhaarnumber() {
		return aadhaarnumber;
	}
	public void setAadhaarnumber(long aadhaarnumber) {
		this.aadhaarnumber = aadhaarnumber;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankUserDetails [id=" + id + ", name=" + name + ", emailid=" + emailid + ", aadhaarnumber="
				+ aadhaarnumber + ", mobilenumber=" + mobilenumber + ", pannumber=" + pannumber + ", pin=" + pin
				+ ", accountnumber=" + accountnumber + ", address=" + address + ", gender=" + gender + ", amount="
				+ amount + ", status=" + status + "]";
	}
	
	
}
