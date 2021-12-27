package com.elms.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.CourseDBInterface;
import com.elms.crud.db.MentorDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Mentor;

public class CourseController implements CourseDBInterface {

	AppSessionManager appSession;
	
	

	public CourseController(AppSessionManager currSession) {
		this.appSession = currSession;
		
	}

	@Override
	public void createCourse(Course newCourse) {
		System.out.println("Creating new Course entry...");
		Session currSession = appSession.getNewAppSession();


		Mentor courseMentor = currSession.get(Mentor.class, 3);
		
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(newCourse);

		newCourse.setCourseMentor(courseMentor);

		currSession.save(newCourse);
		System.out.println("Saving the new Course in DB...");
		appSession.commitSession(currSession);
		System.out.println("Create operation successful!");
	}

	@Override
	public Course getCourseById(int id) {
		System.out.println("fetching the Course with id: " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Course course = currSession.get(Course.class, id);
		appSession.commitSession(currSession);
		System.out.println("Read operation successful!");
		return course;
	}

	@Override
	public List<Course> getCourses() {
		System.out.println("fetching the Course List......");
		Session currSession = appSession.getNewAppSession();
		List<Course> courseList = currSession.createQuery("from Course").getResultList();
		System.out.println("Read operation successful!");
		return courseList;
	}

	@Override
	public void updateCourse(Course updatedCourse) {
		System.out.println("updating the Course with id: " + updatedCourse.getId());
		Session currSession = appSession.getNewAppSession();
		Course dbCopy = currSession.get(Course.class, updatedCourse.getId());

		dbCopy.setTitle(updatedCourse.getDescription());
		dbCopy.setDescription(updatedCourse.getDescription());
		dbCopy.setCourseMentor(updatedCourse.getCourseMentor());

		appSession.commitSession(currSession);
		System.out.println("Update operation successful!");

	}

	@Override
	public void deleteCourseById(int id) {

		System.out.println("Deleting student with id= " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Course dbCopy = currSession.get(Course.class, id);
		currSession.delete(dbCopy);
		appSession.commitSession(currSession);
		System.out.println("Delete operation successful!");

	}

}
