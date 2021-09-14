package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.pojo.Student;

public interface StudentDao {

	public int insert(Student student);
	
	public int update(Student student);
	
	public int remove(int id);
	
	public Student getStudent(int id);
	
	public List<Student> getAllStudents();
}
