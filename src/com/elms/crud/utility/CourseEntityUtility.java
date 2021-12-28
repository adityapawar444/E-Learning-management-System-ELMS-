package com.elms.crud.utility;

import java.util.ArrayList;
import java.util.List;

import com.elms.crud.entity.Course;
import com.elms.crud.entity.Review;
import com.elms.crud.entity.Student;

public class CourseEntityUtility {

	

	public CourseEntityUtility() {
		
	}

	public void addReviewToList(Course course, Review newReview) {
		List<Review> tempList = course.getReviews();

		if (tempList.isEmpty()) {
			tempList = new ArrayList<Review>();
		}
		tempList.add(newReview);
		course.setReviews(tempList);
	}
	
	public void addStudentTiList(Course course,Student newStudent ) {
		List<Student> tempList = course.getStudents();

		if (tempList == null) {
			tempList = new ArrayList<Student>();
		}
		tempList.add(newStudent);
		course.setStudents(tempList);
	}

}
