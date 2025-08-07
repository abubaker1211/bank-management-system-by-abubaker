package com.Bank.DAO;

import java.util.List;

import com.Bank.Entity.BankUserDetails;

public interface BankUserDAO {
	public BankUserDetails insertuserdetails(BankUserDetails details);
	public List<BankUserDetails> alluserdetails();
	public List<BankUserDetails> searchemployees(String filter);
	public BankUserDetails acceptaccountbyid(int id);
	public void rejectaccountbyid(int id);
	
	public BankUserDetails userloginverify(String emailid,int pin);
	
	public BankUserDetails debitoperation(long useraccount,double finalamount);
	
	public void changepin(long accno,int newpin);
	
	public void deleteaccount(long accno);
	
	public String mobiletransfer(long senderacc,double amount,long receiveracc);
	
	public int forgotpassword(long accno,String name,String emailid,long aadhaarno);
	
}
