package com.Bank.DAO;

import java.util.List;

import com.Bank.Entity.AdminDetails;
import com.Bank.Entity.BankUserDetails;

public interface AdminDAO {
	public boolean getadmindetails(String email,String password);
	

}
