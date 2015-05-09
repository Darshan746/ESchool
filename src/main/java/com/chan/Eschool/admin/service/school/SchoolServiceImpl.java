package com.chan.Eschool.admin.service.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chan.Eschool.admin.dao.school.SchoolDao;
import com.chan.Eschool.global.model.School;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	@Transactional
	public School getSchool(long id) {
		     School school = schoolDao.getSchool(id);
		     return school;
	}

}
