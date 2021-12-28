package com.elms.crud.startup;

import java.util.List;

import com.elms.crud.controller.CourseController;
import com.elms.crud.controller.StudentController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.CourseDBInterface;
import com.elms.crud.db.StudentDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Student;

public class CourseEntityTest {

	public static void main(String[] args) {

		AppSessionManager appSession = new AppSessionManager("hibernate.cfg.xml");

		CourseDBInterface thecourseController = new CourseController(appSession);
		StudentDBInterface studentController = new StudentController(appSession);
		// MentorDBInterface mentorController = new MentorController(appSession);

		Course testCourse = new Course("Intervew Guidance", "Specially designed for Engineers.");

		try {
			// thecourseController.createCourse(testCourse);
			// thecourseController.getCourseById(1);
//			if (student != null) {
			// System.out.println(student);
			System.out.println("\n\n\n");
			List<Student> resList = thecourseController.getStudentsforCourse(4);
			for (Student student : resList) {
				System.out.println(student.getFirstName() + " " + student.getLastName());
			}
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n");
//			}
			// thecourseController.addStudentToCourse(4,
			// studentController.getStudentById(7));

			// thecourseController.addStudentToCourse(1,
			// studentController.getStudentById(3));

			// thecourseController.addStudentToCourse(3,
			// studentController.getStudentById(6));

			// thecourseController.deleteCourseById(2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			appSession.closeAppSessionFactory();
		}
	}

}
