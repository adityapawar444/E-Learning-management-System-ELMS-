package com.elms.crud.startup;

import com.elms.crud.controller.MentorController;
import com.elms.crud.db.AppSessionManager;
import com.elms.crud.db.MentorDBInterface;
import com.elms.crud.entity.Mentor;
import com.elms.crud.entity.MentorDetails;

public class MentorEntityTest {

	public static void main(String[] args) {

		AppSessionManager appSession = new AppSessionManager("hibernate.cfg.xml");

		MentorDBInterface mentorController = new MentorController(appSession);

		MentorDetails mDetails = new MentorDetails("Elimination Technique, Answer Writing, Essay Writing, Note Making", "2019,2020,2021",
				"2019,2020", "", (float)4.1);

		try {
		Mentor mentor = new Mentor("TyWin","Lannister",true);
		mentor.setMentorDetails(mDetails);
		
		mentorController.createNewMentor(mentor);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			appSession.closeAppSessionFactory();
		}

	}

}
