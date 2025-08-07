package com.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bank.DAO.StatementDAO;
import com.Bank.Entity.StatementDetails;

@Controller
public class StatementController {
	@Autowired
	StatementDAO statementDAO;
	
	@RequestMapping("/checkstatementpage")
	public String checkstatementpage() {
		return "statement";
	}
	
	@RequestMapping("/checkstatement")
	public String checkstatement(@RequestParam("accno") String userid,Model model) {
		int id=0;
		if(userid!=null){
			id=Integer.parseInt(userid);
		}
		List<StatementDetails> list= statementDAO.checkstatement(id);
		model.addAttribute("transationlist", list);
		return "statement";
	}
}
