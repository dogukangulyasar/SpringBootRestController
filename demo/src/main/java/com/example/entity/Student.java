package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long id;
	private String name;
	@Transient
	private int age;
	private LocalDate dob;
	private String email;



	public Student(){
		
	}
	public Student(Long tmpId, String tmpName, LocalDate tmpDob, String tmpEmail){
		this.id = tmpId;
		this.name = tmpName;
		this.dob = tmpDob;
		this.email = tmpEmail;
	}
	public Student(String tmpName, LocalDate tmpDob, String tmpEmail){
		this.name = tmpName;
		this.dob = tmpDob;
		this.email = tmpEmail;
	}
	public void setId(Long tmpId) {
		this.id = tmpId;
	}
	public void setName(String tmpName) {
		this.name= tmpName;
	}
	public void setAge(int tmpAge) {
		this.age = tmpAge;
	}
	public void setDob (LocalDate tmpDob) {
		this.dob = tmpDob;
	}
	public void setEmail (String tmpEmail) {
		this.email= tmpEmail;
	}
	
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}
	public LocalDate getDob () {
		return this.dob; 
	}
	public String getEmail () {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "Student{" +
			 	"id=" + id+
			 	", name='" + name + '\'' +
			 	", email='" + email + '\'' +
			 	", dob=" + dob + 
			 	",age =" + age +
			 	'}';
	}
	
}
