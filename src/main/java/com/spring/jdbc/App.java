package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.pojo.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// uncomment code for each individual query
		
		// select query
		// Student student = studentDao.getStudent(1);
		// System.out.println(student);

		// insert
		
		//  Student st1 = new Student(5, "ABC", "XYZ"); 
		
		 
		// update
		// Student st1 = new Student(2, "AAAAA", "BBBBB");
		// studentDao.update(st1);

		// delete
	   //	studentDao.remove(1);
		// get all
		
			List<Student> allStudents = studentDao.getAllStudents();
			for(Student s : allStudents)
			{
				System.out.println(s);
			}
	}
}
