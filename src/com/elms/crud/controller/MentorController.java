package com.elms.crud.controller;

import java.util.List;

import org.hibernate.Session;

import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.MentorDBInterface;
import com.elms.crud.entity.Mentor;

public class MentorController implements MentorDBInterface {
	
	AppSessionManager appSession;
	
	public MentorController(AppSessionManager currSession) {
		this.appSession = currSession;
	}

	@Override
	public void createNewMentor(Mentor newMentor) {
		System.out.println("Creating new Mentor entry...");
		Session currSession = appSession.getNewAppSession();
		currSession.save(newMentor);
		System.out.println("Saving the new Mentor in DB...");
		appSession.commitSession(currSession);
		System.out.println("Create operation successful!");
	}

	@Override
	public Mentor getMentorById(int id) {
		System.out.println("fetching the Mentor with id: " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Mentor mentor = currSession.get(Mentor.class, id);
		//System.out.println(mentor.getCourses());
		appSession.commitSession(currSession);
		System.out.println("Read operation successful!");
		return mentor;
	}

	@Override
	public List<Mentor> getMentorByParam(String param, String value) {
		System.out.println("fetching the Mentor where " + param + "=" + value + "......");
		Session currSession = appSession.getNewAppSession();
		List<Mentor> mentorList = currSession.createQuery("from Mentor m where s." + param + "=" + value).getResultList();
		System.out.println("Read operation successful!");
		return mentorList;
	}

	@Override
	public void updateMentor(Mentor updatedMentor) {
		System.out.println("updating the Mentor with id: " + updatedMentor.getId());
		Session currSession = appSession.getNewAppSession();
		Mentor dbCopy = currSession.get(Mentor.class, updatedMentor.getId());
		
		dbCopy.setFirstName(updatedMentor.getFirstName());
		dbCopy.setLastName(updatedMentor.getLastName());
		dbCopy.setAvailable(updatedMentor.isAvailable());
		dbCopy.setMentorDetails(updatedMentor.getMentorDetails());
		
		appSession.commitSession(currSession);
		System.out.println("Update operation successful!");
		
	}

	@Override
	public void deleteMentorById(int id) {
		System.out.println("Deleting Mentor with id= " + id + "...... ");
		Session currSession = appSession.getNewAppSession();
		Mentor dbCopy = currSession.get(Mentor.class, id);
		currSession.delete(dbCopy);
		appSession.commitSession(currSession);
		System.out.println("Delete operation successful!");
		
	}

}
