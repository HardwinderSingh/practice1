package com.hsd.code.modelClass;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="sb_ManyToMany_student")
public class StudentModel {
	@Id
	Integer roll_no;
	String name;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinTable(name="sb_ManyToMany_jointTable",joinColumns = @JoinColumn(name="studentFk"),inverseJoinColumns = @JoinColumn(name="courseFK"))
	List<CoursesModel> list;
}
