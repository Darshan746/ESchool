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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chan.Eschool.admin.service.school.SchoolService;
import com.chan.Eschool.global.model.School;
import com.chan.Eschool.student.model.Student;
import com.chan.Eschool.student.model.StudentPhysicalInfo;
import com.chan.Eschool.student.service.StudentService;

@Controller
public class StudentController {
	
		
		private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
		@Autowired
		private StudentService studentService;
		
		@Autowired
		private SchoolService schoolService;
		
		/**
		 *  This method is used for get the Registration page for student
		 * @param model
		 * @param student
		 * @return "student Registration page"
		 */
		 @RequestMapping(value="/student/register",method=RequestMethod.GET)
		 public String registerStudent(Model model,@ModelAttribute Student student)  {
			 
			 	  return "student/registration";
		 }
		 
		 /**
		  * This Method is used to add the Student to databases to the Organization
		  * @param student
		  * @param redirectAttribute
		  * @return
		  */
	     @RequestMapping(value="/student/register",method=RequestMethod.POST)
		  public String registerStudentToDb(@ModelAttribute Student student,final RedirectAttributes redirectAttribute)  {
	    	 
	    	 	   School school = schoolService.getSchool(1);
	    	 	   student.setSchool(school);
			       Student registerStudent = studentService.registerStudent(student);
		    	   redirectAttribute.addFlashAttribute("RegisteredStudent", registerStudent.getStudent_name());
			       return "redirect:/student/registration/physicalInfo?student_id="+student.getId();
		  }
	     
	     
	     /**
	      * This method is used to get the student Personal Info page 
	      * @param studentPhysicalInfo
	      * @param student_id
	      * @return
	      */
	     @RequestMapping(value="/student/registration/physicalInfo",method=RequestMethod.GET)
	      public String StudentPersonalInfo(@ModelAttribute StudentPhysicalInfo studentPhysicalInfo,@RequestParam long student_id,Model model)   {
	    	 		
	    	 	   model.addAttribute("student_id", student_id);
	    	 	   return "student/registration/physicalInfo";
	     }
	     
	     
	     /**
	      * This method is used to Add The Student Physical Info To DB
	      * @param studentPhysicalInfo
	      * @param id
	      * @param model
	      * @return 
	      */
	     @RequestMapping(value="/physicalinfo",method=RequestMethod.POST)
	     public String addPersonalDataToDb(@ModelAttribute StudentPhysicalInfo studentPhysicalInfo,@RequestParam  long id,Model model)  {
	    	 
			    	 studentPhysicalInfo.setStudent(studentService.getStudentById(id));
			    	 studentService.addPhysicalInfoToDb(studentPhysicalInfo);
			    	 return "student/registration/physicalInfo";
	     }
	     
}