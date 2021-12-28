package com.elms.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.ReviewsDBInterface;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Review;
import com.elms.crud.utility.CourseEntityUtility;

public class ReviewController implements ReviewsDBInterface {

	AppSessionManager appSession;
	// CourseController courseController;

	public ReviewController(AppSessionManager currSession) {
		this.appSession = currSession;
	}

	@Override
	public void createReview(int CourseID, Review newReview) {
		System.out.println("Creating new Review entry...");
		Session currSession = appSession.getNewAppSession();

		Course currCourse = currSession.get(Course.class, CourseID);
		
		CourseEntityUtility courseUtility = new CourseEntityUtility();
		
		courseUtility.addReviewToList(currCourse,newReview);


		currSession.save(newReview);
		System.out.println("Saving the new Review in DB...");
		appSession.commitSession(currSession);
		System.out.println("Create operation successful!");

	}

	@Override
	public Review getReviewById(int id) {
		System.out.println("fetching the Review with id: " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Review review = currSession.get(Review.class, id);
		appSession.commitSession(currSession);
		System.out.println("Read operation successful!");
		return review;
	}

	@Override
	public List<Review> getReviewsForCourse(int CourseId) {
		System.out.println("fetching the Review List......");
		Session currSession = appSession.getNewAppSession();
		Course currCourse = currSession.get(Course.class, CourseId);
		List<Review> reviewList = currCourse.getReviews();
		System.out.println("Read operation successful!");
		return reviewList;
	}

	@Override
	public void updateReview(Review updatedReview) {
		System.out.println("updating the Review with id: " + updatedReview.getId());
		Session currSession = appSession.getNewAppSession();
		Review dbCopy = currSession.get(Review.class, updatedReview.getId());

		dbCopy.setRating(updatedReview.getRating());
		dbCopy.setReviewComment(updatedReview.getReviewComment());
		dbCopy.setReviewDate(updatedReview.getReviewDate());
		dbCopy.setReviewer(updatedReview.getReviewer());

		appSession.commitSession(currSession);
		System.out.println("Update operation successful!");
	}

	@Override
	public void deleteReview(int id) {
		System.out.println("Deleting Review with id= " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Review dbCopy = currSession.get(Review.class, id);
		currSession.delete(dbCopy);
		appSession.commitSession(currSession);
		System.out.println("Delete operation successful!");
	}

}
