package com.web.controller;

import java.util.List;
import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Student;
import com.web.repo.StudentRepo;

@RestController
public class StudentController 
{
	@Autowired
	private StudentRepo stdrepo;
	
//	+++++++++++++++++++++++++++create table and insert data+++++++++++++++++++++++++++++
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student)
	{
		return stdrepo.save(student);
	}
	
//	+++++++++++++++++++++++++ Select only one data form database +++++++++++++++++++
	
	@GetMapping("/get/{stdId}")
	public Student findById(@PathVariable Integer stdId)
	{
		return stdrepo.findById(stdId).get();
	}

	
//	+++++++++++++++++++++++++ Selecting all data form database++++++++++++++++++++++++++
	
	@GetMapping("/getAll")
	public List<Student> findAll()
	{
		return stdrepo.findAll();
	}



// +++++++++++++++++++++++++++++++ update record +++++++++++++++++++++++++++++++

@PutMapping("/update/{stdId}")
public Student updateStudent(@RequestBody Student student, @PathVariable Integer stdId)
{
	Optional<Student> optional = stdrepo.findById(stdId);
	Student student1 = optional.get();
	student1.setStdId(stdId);
	student1.setStdName(student.getStdName());
	student1.setCourse(student.getCourse());
	
	return stdrepo.save(student1);
}
}