package com.Bank.DAO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bank.Entity.BankUserDetails;
import com.Bank.Entity.StatementDetails;
import com.Bank.Repository.BankUserRepository;

@Component
public class BankUserDAOimpl implements BankUserDAO {

	@Autowired
	BankUserRepository bankUserRepository;
	@Autowired
	StatementDAO statementDAO;
	
	@Override
	public BankUserDetails insertuserdetails(BankUserDetails details) {
		details.setStatus("pending");
		return bankUserRepository.save(details);
	}

	@Override
	public List<BankUserDetails> alluserdetails() {
		return bankUserRepository.findAll();
	}

	@Override
	public List<BankUserDetails> searchemployees(String filter) {

		if(filter==null || filter.isEmpty()) {
			return bankUserRepository.findAll();
		}
		else if(isnumeric(filter)) {
			int valuee=Integer.parseInt(filter);
			return bankUserRepository.existsByIdOrAadhaarnumberOrMobilenumberOrPinOraccountnumberOrAmount(valuee);
		}
		else {
			return bankUserRepository.existsByNameOrEmailidOrPannumberOrAddressOrGender(filter);
		}
		
	}
	
	public boolean isnumeric(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public BankUserDetails acceptaccountbyid(int id) {
		BankUserDetails details=bankUserRepository.getById(id);
		details.setStatus("approved");
		Random random=new Random();
		int accountNumber=random.nextInt(1000000);
		if(accountNumber<100000) {
			accountNumber=accountNumber+100000;
		}
		int pinNumber=random.nextInt(10000);
		if(pinNumber<1000) {
			pinNumber=pinNumber+1000;
		}
		details.setAccountnumber(accountNumber);
		details.setPin(pinNumber);
		
		return bankUserRepository.save(details);
		
	}

	@Override
	public void rejectaccountbyid(int id) {
		bankUserRepository.deleteById(id);
	}

	@Override
	public BankUserDetails userloginverify(String emailid, int pin) {
	  BankUserDetails details= bankUserRepository.getByEmailidAndPin(emailid, pin);
	  
	  if(details!=null) {
		if (details.getStatus().equalsIgnoreCase("approved")) {
			return details;
		}
	  }
	  else {
		  return null;
	  }
	return null;
	}

	@Override
	public BankUserDetails debitoperation(long useraccount, double finalamount) {
		BankUserDetails details=bankUserRepository.getByAccountnumber(useraccount);
		details.setAmount(finalamount);
		BankUserDetails result=bankUserRepository.save(details);
		if(result!=null) {
			return result;
		}
		return null;
	}

	@Override
	public void changepin(long accno,int newpin) {
		BankUserDetails details=bankUserRepository.getByAccountnumber(accno);
		details.setPin(newpin);
		bankUserRepository.save(details);
	}

	@Override
	public void deleteaccount(long accno) {
	 BankUserDetails details=bankUserRepository.getByAccountnumber(accno);
	 details.setStatus("cancle");
	 bankUserRepository.save(details);
		
	}

	@Override
	public String mobiletransfer(long senderacc, double amount, long receiveracc) {
		BankUserDetails sender=bankUserRepository.getByAccountnumber(senderacc);
		BankUserDetails receiver= bankUserRepository.getByAccountnumber(receiveracc);
		if(sender!=null && receiver!=null) {
			
			if(amount<=sender.getAmount()) {
				double finalamount=sender.getAmount()-amount;
				BankUserDetails senderfinal=debitoperation(senderacc,finalamount);
				if(senderfinal!=null) {
					StatementDetails statament=new StatementDetails();
					statament.setTransactionamount(amount);
					statament.setUserid(sender.getId());
					statament.setTransationtype("-DB");
					statament.setTimeoftransaction(Time.valueOf(LocalTime.now()));
					statament.setDateoftransaction(Date.valueOf(LocalDate.now()));
					statament.setBalanceamount(finalamount);
					statementDAO.insertstatement(statament);
				}
				
				
				double finalamount2=receiver.getAmount()+amount;
				BankUserDetails receiverfinal=debitoperation(receiveracc, finalamount2);
				if(receiverfinal!=null) {
					StatementDetails statament2=new StatementDetails();
					statament2.setTransactionamount(amount);
					statament2.setUserid(receiver.getId());
					statament2.setTransationtype("+CR");
					statament2.setTimeoftransaction(Time.valueOf(LocalTime.now()));
					statament2.setDateoftransaction(Date.valueOf(LocalDate.now()));
					statament2.setBalanceamount(finalamount2);
					statementDAO.insertstatement(statament2);
				}
				
				if(senderfinal!=null && receiverfinal!=null) {
					return "Transfer Succesfull";
				}
				else {
					return "Server Error404";
				}
			}
			else {
				return "Invalid amount";
			}
			
		}
		return "Server Error404";
		
	}

	@Override
	public int forgotpassword(long accno, String name, String emailid, long aadhaarno) {
		BankUserDetails details=bankUserRepository.getByAccountnumber(accno);
		if(details.getName().equalsIgnoreCase(name)&& details.getEmailid().equalsIgnoreCase(emailid) && details.getAadhaarnumber()==aadhaarno) {
			return details.getPin();
		}
		else {
			return 0;
		}
		
	}
	
	

}
