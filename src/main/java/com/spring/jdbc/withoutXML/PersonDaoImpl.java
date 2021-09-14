package com.spring.jdbc.withoutXML;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.pojo.Student;

public class PersonDaoImpl implements PersonDao {

	RowMapper<Person> rowMapper;
	JdbcTemplate jdbcTemplate;

	public RowMapper<Person> getRowMapper() {
		return rowMapper;
	}

	public void setRowMapper(RowMapper<Person> rowMapper) {
		this.rowMapper = rowMapper;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Person person) {

		String query = "insert into person(id,firstName,lastName)values(?,?,?)";
		int count = jdbcTemplate.update(query, person.getId(), person.getFname(), person.getLname());
		System.out.println(count + " Record inserted.....");
		return count;

	}

	public int update(Person person) {
		String query = "update person set firstName= ? ,lastName =? where id =?";
		int count = this.jdbcTemplate.update(query, person.getFname(), person.getLname(), person.getId());

		System.out.println(count + " Record updated.....");
		return count;
	}

	public int remove(int id) {
		String query = "delete from person where id =?";
		int i = this.jdbcTemplate.update(query, id);
		System.out.println(i + " Records deleted");
		return i;

	}

	public Person getPerson(int id) {
		String query = "select * from person where id = ?";

		Person person = jdbcTemplate.queryForObject(query, rowMapper, id);
		return person;

	}

	public List<Person> getAllPersons() {
		String query = "select * from person";
		List<Person> list = jdbcTemplate.query(query, rowMapper);
		return list;
	}

	/*
	 * public int insert(Student student) { String query =
	 * "insert into student(id,firstName,lastName)values(?,?,?)"; int count =
	 * jdbcTemplate.update(query, student.getId(), student.getFname(),
	 * student.getLname()); System.out.println(count + " Record inserted.....");
	 * return count; }
	 * 
	 * public int update(Student student) { String query =
	 * "update Student set firstName= ? ,lastName =? where id =?"; int count =
	 * this.jdbcTemplate.update(query, student.getFname(), student.getLname(),
	 * student.getId());
	 * 
	 * System.out.println(count + " Record updated....."); return count; }
	 * 
	 * public int remove(int id) {
	 * 
	 * String query = "delete from Student where id =?"; int i =
	 * this.jdbcTemplate.update(query, id); System.out.println(i +
	 * " Records deleted"); return i; }
	 * 
	 * public Student getStudent(int id) { String query =
	 * "select * from student where id = ?";
	 * 
	 * Student student = jdbcTemplate.queryForObject(query, rowMapper, id); return
	 * student; }
	 * 
	 * public List<Student> getAllStudents() { String query =
	 * "select * from student"; List<Student> list = jdbcTemplate.query(query,
	 * rowMapper); return list; }
	 * 
	 * public RowMapper<Student> getRowMapper() { return rowMapper; }
	 * 
	 * public void setRowMapper(RowMapper<Student> rowMapper) { this.rowMapper =
	 * rowMapper; }
	 * 
	 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	 * 
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
	 * jdbcTemplate; }
	 */
}
