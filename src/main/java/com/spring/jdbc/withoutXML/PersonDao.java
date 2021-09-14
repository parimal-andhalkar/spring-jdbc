package com.spring.jdbc.withoutXML;

import java.util.List;

public interface PersonDao {

	public int insert(Person person);
	
	public int update(Person person);
	
	public int remove(int id);
	
	public Person getPerson(int id);
	
	public List<Person> getAllPersons();
}
