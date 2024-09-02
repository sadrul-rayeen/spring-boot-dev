package com.adil.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adil.cruddemo.dao.StudentDAO;
import com.adil.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object... ");
		Student tempStudent = new Student("Adil", "Rayeen", "adil@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the multiple student object
		System.out.println("Creating 2 student object... ");
		Student tempStudent = new Student("Sadrul", "vala", "sadrul@gmail.com");
		Student tempStudent1 = new Student("abcd", "cdef", "abcd@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ... ");
		Student tStudent = new Student("abcd", "defg", "abcd@gmail.com");

		// save the student
		System.out.println("Saving the student ... ");
		studentDAO.save(tStudent);

		// display id of the save student
		int theId = tStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retreive student based on the id: primary key
		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}
}
