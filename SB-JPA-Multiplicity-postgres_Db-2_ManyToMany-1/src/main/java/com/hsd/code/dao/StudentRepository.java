package com.hsd.code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hsd.code.modelClass.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
		@Query("SELECT s.roll_no,s.name,c.course_id,c.course_name FROM StudentModel s RIGHT JOIN s.list as c") 
		List<Object[]> getvalueUserDefine();
		
		
	
		
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
		
		
}
