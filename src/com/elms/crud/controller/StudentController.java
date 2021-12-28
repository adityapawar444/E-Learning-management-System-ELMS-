package com.elms.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.StudentDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Student;

public class StudentController implements StudentDBInterface {

	AppSessionManager appSession;

	public StudentController(AppSessionManager sessionManager) {
		this.appSession = sessionManager;
	}

	@Override
	public void creatNewStudent(Student newStudent) {
		System.out.println("Creating new student object...");
		Session currSession = appSession.getNewAppSession();
		currSession.save(newStudent);
		System.out.println("Saving the student...");
		appSession.commitSession(currSession);
		System.out.println("Create operation successful!");
	}

	@Override
	public Student getStudentById(int id) {
		System.out.println("fetching the student with id: " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Student student = currSession.get(Student.class, id);
		appSession.commitSession(currSession);
		System.out.println("Read operation successful!");
		return student;
	}

	@Override
	public List<Student> getStudentsbyParam(String param, String value) {
		System.out.println("fetching the student where " + param + "=" + value + "......");
		Session currSession = appSession.getNewAppSession();
		List<Student> studentList = currSession.createQuery("from Student s where s." + param + "=" + value)
				.getResultList();
		// List<Student> studentList = session.createQuery("from Student s where
		// s.lastName='Doe'").getResultList();
		System.out.println("Read operation successful!");
		return studentList;
	}

	@Override
	public void updateStudentByParam(int id, String param, String value) {
		
		Session curSession = appSession.getNewAppSession();
		Student targetStudent = curSession.get(Student.class, id);
		System.out.println("updating the student with id: " + id);
		

		switch (param) {

			case "firstName": {
				System.out.println("Updating firstName........");
				targetStudent.setFirstName(value);
				break;
			}
	
			case "lastName": {
				System.out.println("Updating lastName........");
				targetStudent.setLastName(value);
				break;
			}
	
			case "email": {
				System.out.println("Updating email........");
				targetStudent.setEmail(value);
				break;
			}
		}
		appSession.commitSession(curSession);
		System.out.println("Update operation successful!");

	}

	@Override
	public void deleteStudentbyId(int id) {
		System.out.println("Deleting student id= " + id + "...... ");
		Session curSession = appSession.getNewAppSession();
		Student targetStudent = curSession.get(Student.class, id);
		curSession.delete(targetStudent);
		appSession.commitSession(curSession);
		System.out.println("Delete operation successful!");

	}

	@Override
	public List<Course> getCoursesForStudent(int id) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("fetching courses for student :" + id);
		
		Session currSession = appSession.getNewAppSession();
		
		Student dbStudent = currSession.get(Student.class, id);
		
		List<Course> templList = new ArrayList<Course>();
		templList.addAll(dbStudent.getCourses());
		
		System.out.println("Read opeartion successful");
		System.out.println("-----------------------------------------------------------");
		return templList;
	}

}
