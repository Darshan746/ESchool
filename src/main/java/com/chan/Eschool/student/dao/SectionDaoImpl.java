package com.chan.Eschool.student.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.Eschool.student.model.Section;

@Repository("sectionDao")
@SuppressWarnings("unchecked")
public class SectionDaoImpl  implements SectionDao  {
	
			@Autowired
			private SessionFactory sessionFactory;
			
			//private static final Logger logger = LoggerFactory.getLogger(SectionDaoImpl.class);
		
			@Override
			public Section addSection( Section section )  {
				
					Session session =  this.sessionFactory.getCurrentSession();
					session.save(section);
				     return section;
			}
		
			@Override
			public List<Section> getSections()  {
				
					  Session session  =  this.sessionFactory.getCurrentSession();
				      Query query = session.createQuery( "from Section s" );
				      List<Section> sectionList = query.list();
				      return sectionList;
			}
		
			@Override
			public Section getSectionById(Integer id) {
				       
				       Session session = sessionFactory.getCurrentSession();
				       Section section = (Section) session.get( Section.class, id );
				       return  section;
			}
		
			@Override
			public Section updateSection(Section section,Integer section_id)	{
				
				      Session session  =  sessionFactory.getCurrentSession();
				      Section updatedSection  =  (Section)  session.get( Section.class, section_id );
				      updatedSection.setSectionName( section.getSectionName() );
				      session.update( updatedSection );
				      return section;
			}
			
			@Override
			public void deleteSection(Integer section_id)	 {
				
				       Session session = this.sessionFactory.getCurrentSession();
				       Section section =  (Section) session.get(Section.class, section_id);
				       session.delete(section);
			}

}