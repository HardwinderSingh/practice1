package com.hsd.code.modelClass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="sb_ManyToMany_courses")
public class CoursesModel {
	@Id
Integer course_id;
String course_name;
}
