package com.chan.Eschool.student.dao;

import java.util.List;


import com.chan.Eschool.student.model.Section;

public interface SectionDao  {
		  
	      public Section addSection(Section section);
          public List<Section> getSections();
          public Section getSectionById(Integer id);
          public Section updateSection(Section section,Integer section_id);
          public void deleteSection(Integer section_id);
}
