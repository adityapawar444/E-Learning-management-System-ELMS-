package com.elms.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mentor_details")
public class MentorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="prelims")
	private String prelims;
	
	@Column(name="mains")
	private String mains;
	
	@Column(name="interview")
	private String interview;
	
	@Column(name="rating")
	private float rating ;
	
	public MentorDetails() {
		
	}

	public MentorDetails(String skills, String prelims, String mains, String interview, float d) {
		this.skills = skills;
		this.prelims = prelims;
		this.mains = mains;
		this.interview = interview;
		this.rating = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPrelims() {
		return prelims;
	}

	public void setPrelims(String prelims) {
		this.prelims = prelims;
	}

	public String getMains() {
		return mains;
	}

	public void setMains(String mains) {
		this.mains = mains;
	}

	public String getInterview() {
		return interview;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MentorDetails [id=" + id + ", skills=" + skills + ", prelims=" + prelims + ", mains=" + mains
				+ ", interview=" + interview + ", rating=" + rating + "]";
	}
	
	
}
