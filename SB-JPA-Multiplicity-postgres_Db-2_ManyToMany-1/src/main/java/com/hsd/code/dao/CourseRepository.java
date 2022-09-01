package com.hsd.code.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsd.code.modelClass.CoursesModel;

public interface CourseRepository extends JpaRepository<CoursesModel, Integer> {

}
