package com.chan.Eschool.global.service.school;

import java.util.List;

import com.chan.Eschool.global.model.School;


public interface SchoolService {

	public School addSchool(School school);
	public School editSchool(School school);
	public School getSchool(long id);
	public List<School> getSchools();
}
