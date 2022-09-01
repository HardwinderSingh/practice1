package com.hsd.code.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hsd.code.dao.CourseRepository;
import com.hsd.code.dao.StudentRepository;
import com.hsd.code.modelClass.CoursesModel;
import com.hsd.code.modelClass.StudentModel;
//@Component
public class RunnerClass implements CommandLineRunner {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CoursesModel c1 = new CoursesModel(6, null);
//		CoursesModel c2 = new CoursesModel(2, "php");
//		CoursesModel c3 = new CoursesModel(3, "pyhton");
//		CoursesModel c4 = new CoursesModel(4, "bootstrap");
//		
		courseRepository.save(c1);
//		courseRepository.save(c2);
//		courseRepository.save(c3);
//		courseRepository.save(c4);
		
		//StudentModel s1 = new StudentModel(201, "student1", null);

		
	//	studentRepository.save(s1);
		
		

	}

}
