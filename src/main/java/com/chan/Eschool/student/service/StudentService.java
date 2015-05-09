package com.chan.Eschool.student.service;

import com.chan.Eschool.student.model.Student;
import com.chan.Eschool.student.model.StudentPhysicalInfo;

public interface StudentService	{
	
		  public Student   registerStudent ( Student student );
		  public StudentPhysicalInfo  addPhysicalInfoToDb ( StudentPhysicalInfo physicalInfo );
		  public Student getStudentById( Long student_id );
}
