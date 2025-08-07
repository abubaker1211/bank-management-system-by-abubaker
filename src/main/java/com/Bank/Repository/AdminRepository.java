package com.Bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Bank.Entity.AdminDetails;
import com.Bank.Entity.BankUserDetails;

public interface AdminRepository extends JpaRepository<AdminDetails, Integer>{
	
	boolean existsByAdminemailidAndAdminpassword(String emailid,String password);
}
