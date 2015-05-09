package com.chan.Eschool.admin.dao.school;

import java.util.List;

import com.chan.Eschool.global.model.School;


public interface SchoolDao {

	public School addSchool(School school);
	public School editSchool(School school);
	public School getSchool(long id);
	public List<School> getSchools();
}
