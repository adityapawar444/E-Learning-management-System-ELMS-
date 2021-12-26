package com.elms.crud.db;

import java.util.List;

import com.elms.crud.entity.Mentor;

public interface MentorDBInterface {
	
	public void createNewMentor(Mentor newMentor);
	
	public Mentor getMentorById(int id);
	
	public List<Mentor> getMentorByParam(String param, String value);
	
	public void updateMentor(Mentor updatedMentor);
	
	public void deleteMentorById(int id);
	
}
