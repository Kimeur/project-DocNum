package com.ujm.xmltech.services;

import com.ujm.xmltech.entity.Transaction;
import com.ujm.xmltech.entity.file;

public interface TransactionService {

	void createTransaction();
	void createTransaction(Transaction transaction);
	
	//:Transaction getTransactionById(long id);
	
	//void createfile(file file);
	
	//void createOperationReport(Transaction transaction);
	
//	file findfileByMsgId(String msgId);
	
}
