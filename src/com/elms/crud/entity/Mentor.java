package com.elms.crud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mentor")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="is_Available")
	private boolean isAvailable;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mentor_detail_id")
	private MentorDetails mentorDetails;
	

	public Mentor() {
		
	}
	
	public Mentor(String firstName, String lastName, boolean isAvailable) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAvailable = isAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public MentorDetails getMentorDetails() {
		return mentorDetails;
	}

	public void setMentorDetails(MentorDetails mentorDetails) {
		this.mentorDetails = mentorDetails;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", isAvailable="
				+ isAvailable + ", mentorDetails=" + mentorDetails + "]";
	}
	
	
}
