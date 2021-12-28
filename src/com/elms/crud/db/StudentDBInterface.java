package com.elms.crud.db;

import java.util.List;

import com.elms.crud.entity.Course;
import com.elms.crud.entity.Student;

public interface StudentDBInterface {
	
	public void creatNewStudent(Student newStudent);
	
	public Student getStudentById(int id);
	
	public List<Student> getStudentsbyParam(String param, String value);
	
	public void updateStudentByParam(int id,String param, String value);
	
	public void deleteStudentbyId(int id);
	
	public List<Course> getCoursesForStudent(int id);
	

}
