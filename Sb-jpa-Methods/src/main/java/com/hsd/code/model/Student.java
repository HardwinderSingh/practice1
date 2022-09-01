package com.hsd.code.model;

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
@Table(name="sp_methods_td")
public class Student {
	@Id
	Integer id;
	String name;
	String email;
	String adress;

}
