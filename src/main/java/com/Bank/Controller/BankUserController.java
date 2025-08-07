package com.Bank.Controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bank.DAO.BankUserDAO;
import com.Bank.DAO.StatementDAO;
import com.Bank.Entity.BankUserDetails;
import com.Bank.Entity.StatementDetails;
import com.mysql.cj.Session;



@Controller
public class BankUserController {

	@Autowired
	BankUserDAO bankUserDAO;
	@Autowired
	StatementDAO statementDAO;
	
	
	
	@RequestMapping("/registrationpage")
	public String userregistrationpage() {
		return "UserRegistrationPage";
	}
	
	
	@RequestMapping("/registration")
	public String employeeRegistration(BankUserDetails details,Model model) {
		
			BankUserDetails userDetails=bankUserDAO.insertuserdetails(details);
			if(userDetails.getId()>0) {
				model.addAttribute("message", "Registration Sucessfull");
				return "index";
			}
			else {
				model.addAttribute("message", "Server Error 404");
				return "redirect:/registrationpage";
			}
}
	
	
	@RequestMapping("/userlogin")
	public String userlogin() {
		return "Userlogin";
	}
	
	@RequestMapping("/userloginverify")
	public String userloginverify(@RequestParam("useremailid") String emailid,@RequestParam("userpassword") String password,Model model) {
		int pin=0;
		try {
	       pin=Integer.parseInt(password);
			} catch (Exception e) {
				pin=0;
			}
		BankUserDetails details=bankUserDAO.userloginverify(emailid, pin);
		model.addAttribute("userdetails", details);
		if(details!=null) {
			return "Userlogin";
		}
		else {
			model.addAttribute("message", "Invalid User Credentials");
			return"index";
		}
	}
	
	@RequestMapping("/creditpage")
	public String creditpage() {
		return "credit";
	}
	
	@RequestMapping("/crediting")
	public String credit(@RequestParam("useraccount")String useraccount,@RequestParam("useramount") String useramount,HttpSession session,Model model) {
		BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
		double uamount=0;
		double damount=bankUserDetails.getAmount();
		long uaccount=0;
		
		long daccount=bankUserDetails.getAccountnumber();
		
		if(useramount!=null){
			uamount=Long.parseLong(useramount);
		}
		if(useraccount!=null)
		{
		uaccount=Long.parseLong(useraccount);
		}
		double finalamount=0;
		int result=0;
		if(uaccount!=0 && daccount!=0 && uaccount==daccount)
		{
			if(uamount>0){
				finalamount=damount+uamount;
				BankUserDetails updateddetails=bankUserDAO.debitoperation(uaccount, finalamount);
				if(updateddetails!=null) {
					session.setAttribute("userloggedin", updateddetails);
					StatementDetails statament=new StatementDetails();
					statament.setTransactionamount(uamount);
					statament.setUserid(bankUserDetails.getId());
					statament.setTransationtype("+CR");
					statament.setTimeoftransaction(Time.valueOf(LocalTime.now()));
					statament.setDateoftransaction(Date.valueOf(LocalDate.now()));
					statament.setBalanceamount(finalamount);
					statementDAO.insertstatement(statament);
					result=1;
				}
				}
		}
		
		if(result!=0) {
			model.addAttribute("message", "Credit Sucessful");
			return "Userlogin";
		}
		else {
			model.addAttribute("message", "Credit Error");
			return "Userlogin";
		}
	}
	
	@RequestMapping("/debitpage")
	public String debitpage() {
		return "debit";
	}
	
	@RequestMapping("/debiting")
	public String debit(@RequestParam("useraccount")String useraccount,@RequestParam("useramount") String useramount,HttpSession session,Model model) {
		BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
		double uamount=0;
		double damount=bankUserDetails.getAmount();
		long uaccount=0;
		
		long daccount=bankUserDetails.getAccountnumber();
		
		if(useramount!=null){
			uamount=Long.parseLong(useramount);
		}
		if(useraccount!=null)
		{
		uaccount=Long.parseLong(useraccount);
		}
		double finalamount=0;
		int result=0;
		if(uaccount!=0 && daccount!=0 && uaccount==daccount)
		{
			if(uamount>0 && uamount<damount){
				finalamount=damount-uamount;
				BankUserDetails updateddetails=bankUserDAO.debitoperation(uaccount, finalamount);
				if(updateddetails!=null) {
					session.setAttribute("userloggedin", updateddetails);
					StatementDetails statament=new StatementDetails();
					statament.setTransactionamount(uamount);
					statament.setUserid(bankUserDetails.getId());
					statament.setTransationtype("-DB");
					statament.setTimeoftransaction(Time.valueOf(LocalTime.now()));
					statament.setDateoftransaction(Date.valueOf(LocalDate.now()));
					statament.setBalanceamount(finalamount);
					statementDAO.insertstatement(statament);
					result=1;
				}
				}
		}
		
		if(result!=0) {
			model.addAttribute("message", "Debit Sucessful");
			return "Userlogin";
		}
		else {
			model.addAttribute("message", "Debit Error");
			return "Userlogin";
		}
	}
	
	@RequestMapping("/checkbalancepage")
	public String chechbalancepage() {
		return "checkbalance";
	}
	
	@RequestMapping("/changepinpage")
	public String changepinpage() {
		return "Changepin";
	}
	
	@RequestMapping("/changepin")
	public String changepin(@RequestParam("acountnumber") String accno,@RequestParam("oldPin")String oldpin,@RequestParam("NewPin") String pin,Model model,HttpSession session) {
		BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
		int oldpinn=0;
		long accountno=0;
		int newpin=0;
		if(accno!=null && pin!=null && oldpin!=null) {
			try {
				oldpinn=Integer.parseInt(oldpin);
				accountno=Long.parseLong(accno);
				newpin=Integer.parseInt(pin);
			} catch (Exception e) {
				model.addAttribute("message", "Invalid Accno");
				return "Userlogin";
			}
		}
		if(bankUserDetails.getAccountnumber()==accountno && bankUserDetails.getPin()==oldpinn) {
		bankUserDAO.changepin(accountno, newpin);
		model.addAttribute("message","Pin Change sucessfull Log in Again");
		return "index";
		}
		else {
			model.addAttribute("message", "Invalid Accno");
			return "Userlogin";
		}
	}
	
	@RequestMapping("/deleteaccountpage")
	public String deleteaccountpage() {
		return "accountcanclepage";
	}
	
	@RequestMapping("/deleteaccount")
	public String deleteaccount(@RequestParam(value="verify",required=false)String verify,@RequestParam("acountnumber") String accno,HttpSession session,Model model) {
		BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
		long accountno=0;
		if(accno!=null) {
			try {
				accountno=Long.parseLong(accno);
			} catch (Exception e) {
				model.addAttribute("message", "Server Error Try Again");
				return "Userlogin";
			}
		}
		if(bankUserDetails.getAccountnumber()==accountno && "yes".equalsIgnoreCase(verify)) {
			bankUserDAO.deleteaccount(accountno);
			model.addAttribute("message","Account CANCLE Request Sent");
			return "index";
		}
		else {
			model.addAttribute("message", "Invalid Accno");
			return "Userlogin";
		}
	}
	
	
	@RequestMapping("/mobiletransferpage")
	public String transferpage(){
		return "Mobiletransfer";
	}
	
	
	@RequestMapping("/mobiletransfer")
	public String mobiletransfer(@RequestParam("sacountnumber") String sacc,@RequestParam("amount") String amm,@RequestParam("racountnumber") String racc,@RequestParam("pin") String spin,HttpSession session,Model model) {
		BankUserDetails bankUserDetails=(BankUserDetails)session.getAttribute("userloggedin");
		long senderaccount=0;
		double amount=0;
		long receiveraccount=0;
		int senderpin=0;
		if(sacc!=null && amm!=null && racc!=null && spin!=null) {
			try {
				receiveraccount=Long.parseLong(racc);
				amount=Double.parseDouble(amm);
				senderaccount=Long.parseLong(sacc);
				senderpin=Integer.parseInt(spin);
			} catch (Exception e) {
				model.addAttribute("message", "Invalid Credentials");
				return "Userlogin";
			}
		}
		if(senderpin==bankUserDetails.getPin()) {
			String message=bankUserDAO.mobiletransfer(senderaccount, amount, receiveraccount);
			model.addAttribute("message", message);
			return "Userlogin";
			
		}
		model.addAttribute("message", "Invalid Credentials");
		return "Userlogin";
		
	}
	
	@RequestMapping("/forgotpasswordpage")
	public String forgotpasswordpage() {
		return "ForgotPassword";
	}
	
	@RequestMapping("/forgotpassword")
	public String forgotpassword(@RequestParam("name") String name,@RequestParam("acountnumber") String accno,@RequestParam("aadhaarnumber") String addno,@RequestParam("emailid") String emid,Model model) {
		long accountno=0;
		long aadhaarno=0;
		try {
			accountno=Long.parseLong(accno);
			aadhaarno=Long.parseLong(addno);
		} catch (Exception e) {
			model.addAttribute("message", "Invalid Credentials Try Again");
			return "index";
		}
		if(name!=null&& accno!=null && addno!=null && emid!=null) {
			int pin=bankUserDAO.forgotpassword(accountno, name, emid, aadhaarno);
			if(pin!=0) {
				String sping="Dear User Your Pin is :-"+pin;
				model.addAttribute("message",sping);
				return "index";
			}
			else {
				model.addAttribute("message", "Invalid Credentials Try Again");
				return "index";
			}
		}
		else {
			model.addAttribute("message", "Invalid Credentials Try Again");
			return "index";
		}
	}
}

