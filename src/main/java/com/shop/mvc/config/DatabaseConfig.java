package com.shop.mvc.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Bhautik Bhanani
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class DatabaseConfig {

	@Autowired
	Environment env;

	/**
	 * @return data source
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource db = new BasicDataSource();
		db.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		db.setUrl(env.getProperty("jdbc.url"));
		db.setUsername(env.getProperty("jdbc.username"));
		db.setPassword(env.getProperty("jdbc.password"));
		return db;
	}

	/**
	 * @param dataSource
	 * @return transaction manager
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource);
		return tm;
	}

	/**
	 * @param dataSource
	 * @return jdbc template
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
}
