package com.spring.jdbc.withoutXML;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.pojo.Student;

public class RowMapperImpl implements RowMapper<Person> {

	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Person st = new Person();
		st.setId(Integer.parseInt(rs.getString(1)));
		st.setFname(rs.getString(2));
		st.setLname(rs.getString(3));
	
		return st;
	}

}
