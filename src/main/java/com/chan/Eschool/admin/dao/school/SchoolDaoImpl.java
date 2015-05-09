package com.chan.Eschool.admin.dao.school;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.Eschool.global.model.School;


@Repository
public class SchoolDaoImpl implements SchoolDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public School addSchool(School school) {
		if(school.getId() == 0){
			Session session = getSessionFactory().getCurrentSession();
			session.save(school);
			return school;
		}
		return null;
	}

	@Override
	public School editSchool(School school) {
		if(school.getId() == 1){
			Session session = getSessionFactory().getCurrentSession();
			session.update(school);
			return school;
		}
		return null;
	}

	@Override
	public School getSchool(long id) {
		if(id == 1){
			Session session = getSessionFactory().getCurrentSession();
			School school = (School) session.get(School.class, id);
			return school;
		}
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<School> getSchools() {
		Session session = getSessionFactory().getCurrentSession();
		List<School> schools = session.createCriteria(School.class).list();
		return schools;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
