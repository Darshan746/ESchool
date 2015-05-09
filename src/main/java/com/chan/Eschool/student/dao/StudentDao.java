package com.chan.Eschool.student.dao;

import com.chan.Eschool.student.model.Student;
import com.chan.Eschool.student.model.StudentPhysicalInfo;

public interface StudentDao  {
	
		   public Student registerStudent( Student student );
		   public StudentPhysicalInfo addPhysicalInfoToDb( StudentPhysicalInfo physicalInfo );
		   public Student getStudentById( Long student_id );
}
