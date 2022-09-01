package com.hsd.code.runner;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hsd.code.model.Student;
import com.hsd.code.repository.StudentRepo;
import com.hsd.code.repository.StudentRepo.ImportantData;
@Component
public class GetRunner implements CommandLineRunner {
	@Autowired
	StudentRepo studentRepo;
	@Override
	public void run(String... args) throws Exception {
//	List<Student> list = studentRepo.findByidGreaterThan(1);
//		Stream<Student> stream = list.stream();
//		stream.forEach((q)->{System.out.println(q.getName()+" || "+q.getEmail());});
//	
			List<ImportantData> list = studentRepo.findByidGreaterThan(2);
			Stream<ImportantData> stream = list.stream();
			stream.forEach((a)->{System.out.println(a.getName()+" || "+a.getEmail());});
			
			
	}

}
