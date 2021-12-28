package com.elms.crud.startup;

import java.util.List;

import com.elms.crud.controller.StudentController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.StudentDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Student;

public class StudentEntityTest {

	public static void main(String[] args) {

		System.out.println("trying to connect ot DB");
		AppSessionManager sessionManager = new AppSessionManager("hibernate.cfg.xml");
		System.out.println("connection Successful.....");

		StudentDBInterface studentDBcontroller = new StudentController(sessionManager);

		// creating new Student entry in Table
//		Student temp1 = new Student("Robb", "Stark", "stark_senior@winterfell.com");
//		Student temp2 = new Student("Sansa", "Stark", "lady_sansa@winterfell.com");
//		Student temp3 = new Student("Arya", "Stark", "girl_with_no_name@nowhere.com");
//		Student temp4 = new Student("Brandon", "Stark", "three_eyed_raven@wollowtree.com");

		try {
			// create operation
//			studentDBcontroller.creatNewStudent(temp1);
//			studentDBcontroller.creatNewStudent(temp2);
//			studentDBcontroller.creatNewStudent(temp3);
//			studentDBcontroller.creatNewStudent(temp4);

			// read operation

			Student student = studentDBcontroller.getStudentById(7);
			if (student != null) {
				System.out.println(student);
				List<Course> resList =  studentDBcontroller.getCoursesForStudent(student.getId());
				for (Course course : resList) {
					System.out.println(course.getTitle());
				}
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\n\n");
			} else {
				System.out.println("No Records Found!!.......");
			}

//			List<Student> sList = studentDBcontroller.getStudentsbyParam("firstName", "'aditya'");
//			if(sList != null) {
//			System.out.println(sList);
//			}else {
//				System.out.println("No Records Found....");
//			}
//			
			// update operation
			//studentDBcontroller.updateStudentByParam(1, "firstName", "ADITYA");

			// delete operation
			// studentDBcontroller.deleteStudentbyId(2);
		} finally {
			sessionManager.closeAppSessionFactory();
		}

	}

}
