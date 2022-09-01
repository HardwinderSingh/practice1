package com.hsd.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsd.code.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	/**
	 * lessThan <
	 * lessThanEqual <=
	 * GreatherThan >
	 * GreatherThan >=
	 * Between     x,y
	 * Not			!=
	 * In			in Operator
	 * NotIn		not In operator
	 * And 
	 * Or
	 * Like			start with,ends with,containing
	 * 
	 
	 * **/
		List<ImportantData> findByidGreaterThan(Integer no);
		
		
		
		interface ImportantData {
			String getName();
			String getEmail();
		}
		
	
}
