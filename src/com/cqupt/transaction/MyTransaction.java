package com.cqupt.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

public class MyTransaction extends JdbcTransaction implements Transaction {

	public MyTransaction(Connection connection) {
		super(connection);
	}

	public MyTransaction(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
		super(ds, desiredLevel, desiredAutoCommit);
	}
	
	@Override
	public Connection getConnection() throws SQLException{
		return super.getConnection();
	}

	@Override
	public void commit() throws SQLException{
		super.commit();
	}
	
	@Override
	public void rollback() throws SQLException{
		super.rollback();
	}
	
	@Override
	public void close() throws SQLException{
		super.close();
	}
	
	@Override
	public Integer getTimeout() throws SQLException{
		return super.getTimeout();
	}
	
}
