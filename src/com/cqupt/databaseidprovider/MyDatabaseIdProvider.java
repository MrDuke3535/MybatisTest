package com.cqupt.databaseidprovider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

public class MyDatabaseIdProvider implements DatabaseIdProvider {

	Logger log = Logger.getLogger(MyDatabaseIdProvider.class);
	private static final String DATABASE_TYPE_MYSQL="MySQL";
	private static final String DATABASE_TYPE_ORACLE="Oracle";
	private static final String DATABASE_TYPE_DB2="DB2";

	@Override
	public String getDatabaseId(DataSource datasource) throws SQLException {
		Connection connection=datasource.getConnection();
		String dbProductName=connection.getMetaData().getDatabaseProductName();
		if(DATABASE_TYPE_MYSQL.equals(dbProductName)){
			return "mysql";
		}else if(dbProductName.equals(DATABASE_TYPE_ORACLE)){
			return "oracle";
		}else if(dbProductName.equals(DATABASE_TYPE_DB2)){
			return "db2";
		}else{
			return null;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		log.info(properties);
	}

}
