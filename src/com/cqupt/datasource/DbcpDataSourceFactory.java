package com.cqupt.datasource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

/**
 * δѧ����ʱ����
 *<p>title:DbcpDataSourceFactory</p>
 *<p>Decription:</p>
 * @author songxuan
 * @date  ����9:52:23
 */
public class DbcpDataSourceFactory implements DataSourceFactory {
	
	private Properties props=null;
	
	@Override
	public DataSource getDataSource() {
		DataSource dataSource = null;
		
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
		this.props=properties;
	}

}
