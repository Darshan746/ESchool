package com.chan.Eschool.student.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.chan.Eschool.global.model.School;

@Entity
@Table(name="section")
public class Section  implements Serializable  {
	
			private static final long serialVersionUID = 1L;
			private Integer id;
			private String sectionName;
			private School school;
			private List<Student> studentList;
			
			public static long getSerialversionuid() {
				return serialVersionUID;
			}
			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			public Integer getId()  {
				      return id;
			}
			public void setId(Integer id) {
					  this.id = id;
			}
			
			public String getSectionName() {
					  return sectionName;
			}
			public void setSectionName(String sectionName) {
			          this.sectionName = sectionName;
			}
			
			@ManyToOne(fetch=FetchType.EAGER)
			@JoinColumn(name="school_id")
			public School getSchool() {
				      return school;
			}
			public void setSchool(School school) {
				      this.school = school;
			}

			@OneToMany( mappedBy = "section" )
			public List<Student> getStudentList() {
				return studentList;
			}
			public void setStudentList(List<Student> studentList) {
				this.studentList = studentList;
			}
			
}