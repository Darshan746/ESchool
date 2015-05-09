package com.chan.Eschool.global.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.chan.Eschool.student.model.Section;
import com.chan.Eschool.student.model.Student;

@Entity
public class School {

	private long id;
	private String name;
	private String about;
	private Address address;
	private Set<Student> Student;
	private List<Section> Section;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		     return id;
	}
	public void setId(long id) {
		     this.id = id;
	}
	
	public String getName() {
		     return name;
	}
	public void setName(String name) {
		     this.name = name;
	}
	
	public String getAbout() {
			 return about;
	}
	public void setAbout(String about) {
			 this.about = about;
	}
	
	@Embedded
	public Address getAddress() {
		 	 return address;
	}
	public void setAddress(Address address) {
		     this.address = address;
	}
	
	@OneToMany(mappedBy="school")
	public Set<Student> getStudent() {
	     return Student;
	}
	public void setStudent(Set<Student> student) {
	     Student = student;
	}
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="school")
	public List<Section> getSection() {
		return Section;
	}
	public void setSection(List<Section> section) {
		Section = section;
	}
	
}