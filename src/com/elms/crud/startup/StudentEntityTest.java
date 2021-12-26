package com.elms.crud.startup;

import com.elms.crud.controller.StudentController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.StudentDBInterface;
import com.elms.crud.entity.Student;

public class StudentEntityTest {

	public static void main(String[] args) {

		System.out.println("trying to connect ot DB");
		AppSessionManager sessionManager = new AppSessionManager("hibernate.cfg.xml");
		System.out.println("connection Successful.....");

		StudentDBInterface studentDBcontroller = new StudentController(sessionManager);

		// creating new Student entry in Table
		//Student temp = new Student("John", "Snow", "John_Snow@nightswatch.com");

		try {
			// create operation
			// studentDBcontroller.creatNewStudent(temp);

			// read operation

			Student student = studentDBcontroller.getStudentById(1);
			if (student != null) {
				System.out.println(student);
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
