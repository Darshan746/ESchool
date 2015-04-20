package com.chan.Eschool.global.service.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chan.Eschool.admin.dao.school.SchoolDao;
import com.chan.Eschool.global.model.School;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	@Override
	@Transactional
	public School addSchool(School school) {
		return getSchoolDao().addSchool(school);
	}

	@Override
	@Transactional
	public School editSchool(School school) {
		return getSchoolDao().editSchool(school);
	}

	@Override
	@Transactional(readOnly = true)
	public School getSchool(long id) {
		return getSchoolDao().getSchool(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<School> getSchools() {
		return getSchoolDao().getSchools();
	}
	
	public SchoolDao getSchoolDao() {
		return schoolDao;
	}

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}
}
