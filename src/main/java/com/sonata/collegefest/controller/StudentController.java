package com.sonata.collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sonata.collegefest.entity.Student;
import com.sonata.collegefest.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
// To inject a services to controller
	@Autowired
	StudentService studentService;

// To get list of all student
	@RequestMapping("/list")
	public String listStudent(Model theModel) {
		List<Student> theStudent = studentService.findAll();
		theModel.addAttribute("Students",theStudent);
		return "list-Student";
	}
// To get a student form to add
	@RequestMapping("/list/add")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);
		return "Student-form";
	}
	
// To Update a student Information 
	@RequestMapping("/list/update")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("Student", theStudent);
		return"Student-form";
	}
	
// To save a Student who want to register 
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastNmae") String lastName, @RequestParam("department") String department,
			@RequestParam("country") String country) {
		 
		     Student theStudent;
		     if(id != 0) {
		    	 theStudent = studentService.findById(id);
		    	 theStudent.setFirstName(firstName);
		    	 theStudent.setLastName(lastName);
		    	 theStudent.setDepartment(department);
		    	 theStudent.setCountry(country);
		     } else 
		    	 theStudent = new Student(firstName, lastName, department, country);
		      
		     studentService.save(theStudent);
		     return"redirect:/students/list";
	}
	
// To delete a student
	@RequestMapping("/list/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:/students/list";
	}

}
