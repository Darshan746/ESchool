package com.chan.Eschool.student.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chan.Eschool.admin.service.school.SchoolService;
import com.chan.Eschool.student.model.Section;
import com.chan.Eschool.student.service.SectionService;

@Controller
@SuppressWarnings("unused")
public class SectionController  {
	
		
		private static final Logger log = LoggerFactory.getLogger( SectionController.class );
		
		  @Autowired
	      private SectionService sectionService;
		  
		  @Autowired
		  private SchoolService schoolService;
		  
		  
		  /**
		   * This method is used to get the Add Section Page
		   * @param section
		   * @param model
		   * @return "addSecttion page"
		   */
		  @RequestMapping( value="/section/addSection",method=RequestMethod.GET )
		  public String getAddSectionPage ( @ModelAttribute Section section,Model model )   {
			  
			        model.addAttribute( "sectionId", new Integer(0) );
			  		model.addAttribute( "sectionList", sectionService.getSections() );
			        return "section/addSection" ;
		  }
		  
		  
		  /**
		   * This method is used to add the new section 
		   * @param section
		   * @return "addSecttion page"
		   */
		  @RequestMapping( value="/section/addSection",method=RequestMethod.POST )
		  public String addSection( @ModelAttribute Section section )  {
			  
			  		section.setSchool( schoolService.getSchool ( 1 ) );
			  		sectionService.addSection( section );
			        return "redirect:/section/addSection";
		  }
		  
		  
		  /**
		   * This method is used to edit the section using Section_id
		   * @param section
		   * @param section_id
		   * @param model
		   * @return  "addSecttion page"
		   */
		  @RequestMapping( value="/section/editSection",method=RequestMethod.GET )
	      public String editSection( @ModelAttribute Section section,@RequestParam Integer section_id,Model model )	{
	    	  
	    	       model.addAttribute( "sectionId", section_id );
	    	       model.addAttribute( "sectionObject", sectionService.getSectionById(section_id) );
	    	       model.addAttribute( "sectionList", sectionService.getSections() );
	    	       return  "section/addSection";
			  }
		  
		  
		  /**
		   * this method is used to update the edited section using section_id
		   * @param section
		   * @param model
		   * @param section_id
		   * @return "addSecttion page"
		   */
		  @RequestMapping( value="/section/updateSection",method=RequestMethod.POST )
		   public String updateSection( @ModelAttribute Section section,Model model,@RequestParam Integer section_id ) 	{
			       
	                model.addAttribute("sectionObject", sectionService.getSectionById(section_id));
		    	    model.addAttribute("sectionList", sectionService.getSections());
			  		sectionService.updateSection(section,section_id);
			  		return "redirect:/section/addSection";
		  }
		  
		  
		  /**
		   * This method is used to delete the section using section_id
		   * @param section_id
		   * @param model
		   * @return "addSecttion page"
		   */
		  @RequestMapping(value="/section/deleteSection",method=RequestMethod.GET)
		  public String deleteSection( @RequestParam Integer section_id,Model model )	{
			  
			        sectionService.deleteSection( section_id );
			        model.addAttribute( "sectionObject", sectionService.getSectionById( section_id ) );
		    	    model.addAttribute( "sectionList", sectionService.getSections( ) );
			        return "redirect:/section/addSection";
		  }
}