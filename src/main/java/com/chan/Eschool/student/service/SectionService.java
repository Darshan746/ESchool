package com.chan.Eschool.student.service;

import java.util.List;



import com.chan.Eschool.student.model.Section;

public interface SectionService  {
	
		      public Section addSection(Section section);
		      public List<Section> getSections();
		      public Section getSectionById(Integer id);
		      public Section updateSection(Section section,Integer section_id);
		      public void deleteSection(Integer section_id);
}
