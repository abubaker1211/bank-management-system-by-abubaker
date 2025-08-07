package com.Bank.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Bank.Entity.StatementDetails;
import com.Bank.Repository.StatementRepository;

@Component
public class StatementDAOimpl implements StatementDAO{

	@Autowired
	StatementRepository statementRepository;
	@Override
	public List<StatementDetails> checkstatement(int userid) {
		return statementRepository.getByUserid(userid);
	}
	@Override
	public StatementDetails insertstatement(StatementDetails statement) {
		return statementRepository.save(statement);
		
	}

}
