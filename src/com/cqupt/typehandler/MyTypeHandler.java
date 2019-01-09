package com.cqupt.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {
	Logger log = Logger.getLogger(MyTypeHandler.class);

	@Override
	public String getResult(ResultSet resultset, String s) throws SQLException {
		String result = resultset.getString(s);
		log.info("读取string参数1【"+result+"】");
		return result;
	}

	@Override
	public String getResult(ResultSet resultset, int i) throws SQLException {
		String result = resultset.getString(i);
		log.info("设置string参数2【"+result+"】");
		return result;
	}

	@Override
	public String getResult(CallableStatement callablestatement, int i) throws SQLException {
		String result = callablestatement.getString(i);
		log.info("设置string参数3【"+result+"】");
		return result;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, String arg2, JdbcType arg3) throws SQLException {
		log.info("设置string参数【"+arg2+"】");
	}

}
