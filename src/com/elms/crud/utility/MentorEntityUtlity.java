package com.elms.crud.utility;

import java.util.ArrayList;
import java.util.List;

import com.elms.crud.controller.MentorController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.entity.Course;
import com.elms.crud.entity.Mentor;

public class MentorEntityUtlity {
	
	Mentor mentor;
	AppSessionManager appSession;
	
	public MentorEntityUtlity(Mentor currMentor, AppSessionManager currSession) {
		this.mentor = currMentor;
		this.appSession = currSession;
	}
	
	public void addCourseToList(Course course) {
		
		List<Course> tempList = mentor.getCourses();
		
		if(mentor.getCourses() == null) {
			tempList = new ArrayList<>();
			tempList.add(course);
			mentor.setCourses(tempList);
		}else {
			tempList.add(course);
		}
		
	}
	
	public List<Course> getCourseList(int mentorId){
		MentorController controller = new MentorController(appSession);
		return controller.getCourseListForMentor(mentorId);
	}

}
