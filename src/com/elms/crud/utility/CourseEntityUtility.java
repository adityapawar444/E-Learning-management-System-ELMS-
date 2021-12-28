package com.elms.crud.utility;

import java.util.ArrayList;
import java.util.List;

import com.elms.crud.entity.Course;
import com.elms.crud.entity.Review;

public class CourseEntityUtility {

	Course course;

	public CourseEntityUtility(Course currCourse) {
		this.course = currCourse;
	}

	public void addReviewToList(Review newReview) {
		List<Review> tempList = course.getReviews();

		if (tempList.isEmpty()) {
			tempList = new ArrayList<Review>();
		}
		tempList.add(newReview);
		course.setReviews(tempList);
	}

}
