package com.elms.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.CourseDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Mentor;
import com.elms.crud.entity.Student;
import com.elms.crud.utility.CourseEntityUtility;
import com.elms.crud.utility.MentorEntityUtlity;

public class CourseController implements CourseDBInterface {

	AppSessionManager appSession;
	CourseEntityUtility courseUtility;

	public CourseController(AppSessionManager currSession) {
		this.appSession = currSession;
		this.courseUtility = new CourseEntityUtility();
	}

	@Override
	public void createCourse(Course newCourse) {
		System.out.println("Creating new Course entry...");
		Session currSession = appSession.getNewAppSession();

		Mentor courseMentor = currSession.get(Mentor.class, 3);
		MentorEntityUtlity mentorUtility = new MentorEntityUtlity(courseMentor, appSession);
		mentorUtility.addCourseToList(newCourse);
//		List<Course> courseList = new ArrayList<Course>();
//		courseList.add(newCourse);

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

	@Override
	public void addStudentToCourse(int courseId, Student student) {
		System.out.println("........Adding course " + courseId + " to student " + student.getId() + "..........");
		Session currSession = appSession.getNewAppSession();

		Course dbCourse = currSession.get(Course.class, courseId);

		/*
		 * if(student.getId() == 0) { currSession.save(student); }
		 */

		courseUtility.addStudentTiList(dbCourse, student);

		appSession.commitSession(currSession);

		System.out.println(".........Student added to Course successfully...........");

	}

	@Override
	public List<Student> getStudentsforCourse(int id) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("fetching Students for course :" + id);
		
		Session currSession = appSession.getNewAppSession();
		
		Course dbCourse = currSession.get(Course.class, id);
		
		List<Student> templList = new ArrayList<Student>();
		templList.addAll(dbCourse.getStudents());
		
		System.out.println("Read opeartion successful");
		System.out.println("-----------------------------------------------------------");
		return templList;
		
	}

}
