package com.adil.cruddemo;

import java.util.List;

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
			createMultipleStudent(studentDAO);

			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentByLatsName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
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

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tStudent : theStudents) {
			System.out.println(tStudent);
		}
	}

	private void queryForStudentByLatsName(StudentDAO studentDAO) {
		List<Student> thStudents = studentDAO.findByLastName("vala");

		for (Student tStudent : thStudents) {
			System.out.println(tStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrive student based on the id: primary key
		int id = 1;
		System.out.println("Getting student with id : " + id);
		Student myStudent = studentDAO.findById(id);

		// change first name to "scooby"
		System.out.println("updating student...");
		myStudent.setFirstName("sadrul");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + rowsDeleted);
	}
}
	