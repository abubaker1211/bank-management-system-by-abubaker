package com.Bank.DAO;

import java.util.List;

import com.Bank.Entity.StatementDetails;

public interface StatementDAO {
	public List<StatementDetails> checkstatement(int userid);
	
	public StatementDetails insertstatement(StatementDetails statement);

}
