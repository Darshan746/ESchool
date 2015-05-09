package com.chan.Eschool.student.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.chan.Eschool.global.model.Address;
import com.chan.Eschool.global.model.School;

@Entity
@Table(name="student")
public class Student {
	
	private long id;
	private String student_name;
	private String roll_no;
	private String standard;
	private School school;
	private Address address;
	private StudentPhysicalInfo physicalInfo;
	private Section section;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId()  {
		      return id;
	}
	public void setId(long id)  {
		      this.id = id;
	}
	
	public String getStudent_name()  {
			  return student_name;
	}
	public void setStudent_name(String student_name)  {
		      this.student_name = student_name;
	}
	
	public String getRoll_no()  {
		     return roll_no;
	}
	public void setRoll_no(String roll_no)  {
		 	  this.roll_no = roll_no;
	}
	
	public String getStandard()  {
			  return standard;
	}
	public void setStandard(String standard)  {
			  this.standard = standard;
	}
	
	@ManyToOne
	@JoinColumn(name="school_id")
	public School getSchool()  {
			  return school;
	}
	public void setSchool(School school)  {
			  this.school = school;
	}
	
	@Embedded
	public Address getAddress()  {
		      return address;
	}
	public void setAddress(Address address)  {
			  this.address = address;
	}
	
	@OneToOne(mappedBy="student",cascade=CascadeType.ALL)
	public StudentPhysicalInfo getPhysicalInfo()  {
			  return physicalInfo;
	}
	public void setPhysicalInfo(StudentPhysicalInfo physicalInfo)  {
		 	  this.physicalInfo = physicalInfo;
	}
	
	@OneToOne
	@JoinColumn(name =" section_Id")
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	
}