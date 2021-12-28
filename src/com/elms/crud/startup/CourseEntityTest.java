package com.elms.crud.startup;

import java.util.ArrayList;
import java.util.List;

import com.elms.crud.controller.CourseController;
import com.elms.crud.controller.MentorController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.CourseDBInterface;
import com.elms.crud.db.MentorDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Mentor;

public class CourseEntityTest {
	
	public static void main(String[] args) {
	
		AppSessionManager appSession = new AppSessionManager("hibernate.cfg.xml");

		CourseDBInterface thecourseController = new CourseController(appSession);
		//MentorDBInterface mentorController = new MentorController(appSession);
		
		Course testCourse = new Course("Intervew Guidance", "Specially designed for Engineers.");
		
		

		try {
		thecourseController.createCourse(testCourse);	
		//thecourseController.getCourseById(1);
		//thecourseController.deleteCourseById(2);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			appSession.closeAppSessionFactory();
		}
	}
	
	
		
	

}
