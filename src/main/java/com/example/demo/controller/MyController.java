package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;




@RestController
public class MyController {
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/")
	@ResponseBody
	String hello() {
		return "home.jsp";
		
	}
	
	@GetMapping("/home")
	public String home(){
		
		return "Welcome";
	}
	@GetMapping("/courses") 
	public List<Course> getCourses(){
		return this.courseservice.getCourses();
		
	}
	@GetMapping("/courses/{id}") 
	public Course getCourse(@PathVariable String id){
		return this.courseservice.getCourse(Long.parseLong(id));
		
	}
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseservice.updateCourse(course);
	}
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
	}


//
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>