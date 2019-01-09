package com.cqupt.transaction;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

public class MyTransactionFactory implements TransactionFactory {


	@Override
	public Transaction newTransaction(Connection connection) {
		return new MyTransaction(connection);
	}

	@Override
	public Transaction newTransaction(DataSource datasource, TransactionIsolationLevel transactionisolationlevel,
			boolean flag) {
		return new MyTransaction(datasource,transactionisolationlevel,flag);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
