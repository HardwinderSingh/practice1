package com.hsd.code.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hsd.code.dao.StudentRepository;
import com.hsd.code.modelClass.StudentModel;

@Component
public class GetDataRunner implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		  Optional<StudentModel> studentModel = studentRepository.findById(101);
//		System.out.println(studentModel);
	
			List<Object[]> list = studentRepository.getvalueUserDefine();
			for (Object[] a : list) {
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
			System.out.println("-------------------------------");
		}
	}
}

