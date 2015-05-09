package com.chan.Eschool.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.Eschool.student.model.Student;
import com.chan.Eschool.student.model.StudentPhysicalInfo;

@Repository("studentRegistrationDao")
public class StudentDaoImpl  implements StudentDao{
	
    @Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student registerStudent(Student student) {
		 Session session = sessionFactory.getCurrentSession();
		 session.save(student);
		 return student;
	}
	
	/**
	 * This method is used to save the Student Personal data to The DB
	 * @param physicalInfo
	 */
	@Override
	public   StudentPhysicalInfo   addPhysicalInfoToDb ( StudentPhysicalInfo physicalInfo )  {
			  Session session  =  sessionFactory.getCurrentSession();
		      session.save(physicalInfo);
		      return physicalInfo;
	}

	@Override
	public Student getStudentById(Long student_id) {
	
			 Session session  =  sessionFactory.getCurrentSession();
			 Student student = (Student) session.get(Student.class, student_id);
			 return student;
	}
	
}