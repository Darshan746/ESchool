package com.chan.Eschool.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chan.Eschool.student.dao.StudentDao;
import com.chan.Eschool.student.model.Student;
import com.chan.Eschool.student.model.StudentPhysicalInfo;

@Service("studentRegistrationService")
public class StudentServiceImpl  implements StudentService  {
	
	 @Autowired
	  private StudentDao studentDao;

	  @Override
	  @Transactional
	  public Student registerStudent(Student student) {
		      	
		        return studentDao.registerStudent(student);
	 }
	  
	  @Override
	  @Transactional
	  public StudentPhysicalInfo addPhysicalInfoToDb( StudentPhysicalInfo physicalInfo ) {
		  
		        return  studentDao.addPhysicalInfoToDb ( physicalInfo );
	  }

	@Override
	@Transactional
	public Student getStudentById(Long student_id) {
		
		      return studentDao.getStudentById(student_id);
	}

}