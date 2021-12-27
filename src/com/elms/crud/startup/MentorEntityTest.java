package com.elms.crud.startup;

import com.elms.crud.controller.MentorController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.MentorDBInterface;
import com.elms.crud.entity.Mentor;
import com.elms.crud.entity.MentorDetails;
import com.elms.crud.utility.MentorEntityUtlity;

public class MentorEntityTest {

	public static void main(String[] args) {

		AppSessionManager appSession = new AppSessionManager("hibernate.cfg.xml");

		MentorDBInterface mentorController = new MentorController(appSession);

//		MentorDetails mDetails = new MentorDetails("Elimination Technique, Answer Writing, Essay Writing, Note Making", "2019,2020,2021",
//				"2019,2020", "", (float)4.1);

		try {
			Mentor mentor = mentorController.getMentorById(3);
//		Mentor mentor = new Mentor("TyWin","Lannister",true);
//		mentor.setMentorDetails(mDetails);
//		
//		mentorController.createNewMentor(mentor);+
			System.out.println(".........");
			System.out.println(mentor.getFirstName());
			System.out.println(mentor.getLastName());
			System.out.println(mentor.getMentorDetails().getSkills());
			System.out.println(new MentorEntityUtlity(mentor, appSession).getCourseList(mentor.getId()));
			System.out.println(".........");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			appSession.closeAppSessionFactory();
		}

	}

}
