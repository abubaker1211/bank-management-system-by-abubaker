package com.Bank.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Bank.Entity.BankUserDetails;

public interface BankUserRepository extends JpaRepository<BankUserDetails, Integer> {

	@Query("select user from BankUserDetails user where user.name=?1 or user.emailid=?1 or user.pannumber=?1 or user.address=?1 or user.gender=?1")
	List<BankUserDetails> existsByNameOrEmailidOrPannumberOrAddressOrGender(String value);
	@Query("select user from BankUserDetails user where user.id=?1 or user.aadhaarnumber=?1 or user.mobilenumber=?1 or user.pin=?1 or user.accountnumber=?1 or user.amount=?1")
	List<BankUserDetails> existsByIdOrAadhaarnumberOrMobilenumberOrPinOraccountnumberOrAmount(int value);
	
	BankUserDetails getByEmailidAndPin(String emailid,int pin);
	
	BankUserDetails getByAccountnumber(long accountnumber);
	
}
