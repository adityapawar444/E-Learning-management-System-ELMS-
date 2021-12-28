package com.elms.crud.db;

import java.util.List;

import com.elms.crud.entity.Review;

public interface ReviewsDBInterface {
	
	public void createReview(int CourseID, Review newReview);
	
	public Review getReviewById(int id);
	
	public List<Review> getReviewsForCourse(int CourseId);
	
	public void updateReview(Review updatedCourse);
	
	public void deleteReview(int id);

}
