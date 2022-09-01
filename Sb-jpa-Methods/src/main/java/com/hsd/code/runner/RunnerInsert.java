package com.hsd.code.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hsd.code.model.Student;
import com.hsd.code.repository.StudentRepo;
//@Component
public class RunnerInsert implements CommandLineRunner {
	@Autowired
	StudentRepo studentRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
			Student student = new Student(1,"student1","student1@gmail.com","up");
			studentRepo.save(student);
	}

}
