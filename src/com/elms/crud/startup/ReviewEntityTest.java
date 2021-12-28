package com.elms.crud.startup;

import java.util.Date;

import com.elms.crud.controller.ReviewController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.ReviewsDBInterface;
import com.elms.crud.entity.Review;

public class ReviewEntityTest {

	public static void main(String[] args) {
	
		AppSessionManager appSessionManager = new AppSessionManager("hibernate.cfg.xml");
		
		ReviewsDBInterface reviewController = new ReviewController(appSessionManager);
		
		Review testReview1 = new Review(4, "Good Course Overall", new Date(), "testUser");
		Review testReview2 = new Review(3, "Too lengthly ecplainations", new Date(), "testUser");
		Review testReview3 = new Review(5, "Best in market!!!", new Date(), "testUser");
		
		try {
			//reviewController.deleteReview(1);
			
			reviewController.createReview(3, testReview1);
			reviewController.createReview(3, testReview2);
			reviewController.createReview(3, testReview3);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			appSessionManager.closeAppSessionFactory();
		}

	}

}
