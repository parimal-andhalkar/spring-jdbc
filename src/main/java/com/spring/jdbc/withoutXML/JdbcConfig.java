package com.spring.jdbc.withoutXML;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {

	
	@Bean("ds")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		//ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJDBCTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public RowMapper<Person> getRowMapper() {
		
		RowMapper<Person> rowMapper = new RowMapperImpl();
		return rowMapper;
	}
	
	@Bean("personDao")
	public PersonDao getPersonDao()
	{
		PersonDaoImpl dao = new PersonDaoImpl();
		dao.setJdbcTemplate(getJDBCTemplate());
		dao.setRowMapper(getRowMapper());
		
		return dao;
	}
}
