package com.adil.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adil.cruddemo.dao.AppDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleteing instructor id: " + theId);
	
		appDAO.deleteInstructorById(theId);
	
		System.out.println("Done!");
	}

	/* 
	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
	
		Instructor tempInstructor = appDAO.findInstructorById(theId);
	
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}
	*/
	
	/* 
	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
	
		//create the instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");
	
	
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
	
		// save the instructor
	
		// Note: this will also save the details object
		// because of CascadeType.ALL
	
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
	
		System.out.println("Done!");
	}
	*/

}
