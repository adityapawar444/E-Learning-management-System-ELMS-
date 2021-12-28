package com.elms.crud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="review_comment")
	private String reviewComment;
	
	@Column(name="review_date")
	private Date reviewDate;
	
	@Column(name="reviewer")
	private String reviewer;
	
	public Review() {
		
	}

	public Review(int rating, String reviewComment, Date reviewDate, String reviewer) {
		super();
		this.rating = rating;
		this.reviewComment = reviewComment;
		this.reviewDate = reviewDate;
		this.reviewer = reviewer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	@Override
	public String toString() {
		return "CourseReviews [id=" + id + ", rating=" + rating + ", reviewComment=" + reviewComment + ", reviewDate="
				+ reviewDate + ", reviewer=" + reviewer + "]";
	}
	
	
}
