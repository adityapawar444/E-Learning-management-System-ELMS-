package com.elms.crud.db;

import java.util.List;

import com.elms.crud.entity.Course;

public interface CourseDBInterface {

	public void createCourse(Course newCourse);
	
	public Course getCourseById(int id);
	
	public List<Course> getCourses();
	
	public void updateCourse(Course updatedCourse);
	
	public void deleteCourseById(int id);
	
}
