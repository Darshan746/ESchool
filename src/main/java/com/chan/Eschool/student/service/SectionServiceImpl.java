package com.chan.Eschool.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chan.Eschool.student.dao.SectionDao;
import com.chan.Eschool.student.model.Section;

@Service("sectionService")
public class SectionServiceImpl implements SectionService	{
	
			@Autowired
			private SectionDao  sectionDao;
		
			@Override
			@Transactional
			public Section addSection(Section section)	{
				
				      return sectionDao.addSection(section);
			}
		
			@Override
			@Transactional
			public List<Section> getSections()	{
				
			       	  return sectionDao.getSections();
			}
		
			@Override
			@Transactional
			public Section getSectionById(Integer id)	 {
				
				      return sectionDao.getSectionById(id);
			}
		
			@Override
			@Transactional
			public Section updateSection(Section section,Integer section_id)	 {
				
				      return sectionDao.updateSection(section,section_id);
			}

			@Override
			@Transactional
			public void deleteSection(Integer section_id) {
				       
				       sectionDao.deleteSection(section_id);
				
			}

}