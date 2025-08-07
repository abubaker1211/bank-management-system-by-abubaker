package com.Bank.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.Entity.AdminDetails;
import com.Bank.Repository.AdminRepository;

@Component
public class AdminDAOimpl implements AdminDAO {

	@Autowired
	AdminRepository adminRepository;
	@Override
	public boolean getadmindetails(String email, String password) {
		return adminRepository.existsByAdminemailidAndAdminpassword(email, password);
	}

}
