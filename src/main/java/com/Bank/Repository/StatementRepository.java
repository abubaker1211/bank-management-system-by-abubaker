package com.Bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.Entity.StatementDetails;

public interface StatementRepository extends JpaRepository<StatementDetails, Integer> {
	 List<StatementDetails> getByUserid(int userid);
}
