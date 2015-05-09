package com.chan.Eschool.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student_physical_info")
public class StudentPhysicalInfo  {
	     
	      private long id;
	      private Date dob;
	      private double height;
	      private double weight;
	      private Student student;
	      
	  
		 @Id
	     @GeneratedValue(strategy=GenerationType.IDENTITY)
		  public long getId()  {
				    return id;
		  }
		  public void setId(long id)  {
				    this.id = id;
			}
		  
	@DateTimeFormat(pattern="yyyy-MM-dd")
		  public Date getDob() {
				    return dob;
		  }
		  public void setDob(Date dob) {
				    this.dob = dob;
		  }
			
		  public double getHeight() {
				    return height;
		  }
		  public void setHeight(double height) {
				    this.height = height;
		  }
			
		  public double getWeight() {
				    return weight;
		   }
		   public void setWeight(double weight) {
				     this.weight = weight;
		   }
			
			@OneToOne
			@JoinColumn(name="student_id")
		    public Student getStudent() {
					  return student;
			}
			public void setStudent(Student student) {
					  this.student = student;
			}
}