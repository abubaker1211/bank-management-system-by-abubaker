package com.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bank.DAO.AdminDAO;
import com.Bank.DAO.BankUserDAO;
import com.Bank.Entity.BankUserDetails;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	BankUserDAO bankUserDAO;
	
	@RequestMapping("/adminlogin")
	public String adminlogin() {
		return "Adminlogin";
	}
	
	@RequestMapping("/adminloginpage")
	public String admingloginpage(@RequestParam("adminemailid") String emailid,@RequestParam("adminpassword") String password,Model model) {
			
		boolean status=adminDAO.getadmindetails(emailid, password);
		if(status) {
			return "redirect:/adminlogin";
		}
		else {
			model.addAttribute("message", "Invalid Admin Credentials");
			return"index";
		}
	}
	
	@RequestMapping("/alluserdetails")
	public String alluserdetails(Model model) {
		List<BankUserDetails> allusers=bankUserDAO.alluserdetails();
		model.addAttribute("allusers", allusers);
		return "Alluserdetails";
	}
	
	@RequestMapping("/accountrequestdetails")
	public String accountrequestdetails(Model model) {
		List<BankUserDetails> allusers=bankUserDAO.alluserdetails();
		model.addAttribute("allusers", allusers);
		return "AccountrequestDetails";
	}
	
	@RequestMapping("/searchemployees")
	public String searchEmployees(@RequestParam("filter") String filtervalue,Model model) {
		List<BankUserDetails> list=bankUserDAO.searchemployees(filtervalue);
		model.addAttribute("allusers",list);
		System.out.println(list);
		return "Alluserdetails";
		
	}
	
	@RequestMapping("/searchemployeesaccreq")
	public String searchEmployeesinaccountrequest(@RequestParam("filter") String filtervalue,Model model) {
		List<BankUserDetails> list=bankUserDAO.searchemployees(filtervalue);
		model.addAttribute("allusers",list);
		return "AccountrequestDetails";
		
	}
	
	@RequestMapping("/accountcanclerequest")
	public String accountcanclerequest(Model model) {
		List<BankUserDetails> allusers=bankUserDAO.alluserdetails();
		model.addAttribute("allusers", allusers);
		return "AccountCancleRequest";
	}
	
	@RequestMapping("/searchemployeescanclerequest")
	public String searchEmployeesincanclerequest(@RequestParam("filter") String filtervalue,Model model) {
		List<BankUserDetails> list=bankUserDAO.searchemployees(filtervalue);
		model.addAttribute("allusers",list);
		return "AccountCancleRequest";
		
	}
	
	@RequestMapping("/acceptaccount")
	public String acceptaccount(@RequestParam("eid") String id) {
		int eid= Integer.parseInt(id);
		BankUserDetails details=bankUserDAO.acceptaccountbyid(eid);
		return "redirect:/accountrequestdetails";
		
	}
	
	@RequestMapping("/rejectaccount")
	public String rejectaccount(@RequestParam("eid") String id) {
		int eid=Integer.parseInt(id);
		bankUserDAO.rejectaccountbyid(eid);
		return "redirect:/accountrequestdetails";		
	}
	
	
	

}
