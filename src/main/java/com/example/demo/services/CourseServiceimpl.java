package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Course;
@Service
public class CourseServiceimpl implements CourseService {
	List<Course> list;  //MainImportande 	Half/DaY Boka
	
	@Autowired
private CourseDao coursedao;
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}
	
	@Override
	public Course getCourse(long id) {
		// TODO Auto-generated method stub
		
		list=coursedao.findAll(); //Very IMP
		return coursedao.getOne(id);
	}
	
	@Override
	public Course addCourse(Course course) {
	//	list.add(course);
		coursedao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		coursedao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long courseId) {
		Course entity=coursedao.getOne(courseId);
		coursedao.delete(entity);
//		list.forEach(e -> {
//			if(e.getId() == courseId) {
//				list.indexOf(courseId);
//			list.remove(0)
//			}
//		});
//		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	}
	
	

}
