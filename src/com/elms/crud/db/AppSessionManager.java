package com.elms.crud.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elms.crud.entity.Course;
import com.elms.crud.entity.Review;
import com.elms.crud.entity.Mentor;
import com.elms.crud.entity.MentorDetails;
import com.elms.crud.entity.Student;

public class AppSessionManager {

	private SessionFactory sessionFactory;
	Session appSession;

	public AppSessionManager(String configFile) {
		sessionFactory = new Configuration().configure(configFile)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Mentor.class)
				.addAnnotatedClass(MentorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	}

	public Session getNewAppSession() {
		Session appSession = sessionFactory.getCurrentSession();
		appSession.beginTransaction();
		return appSession;
	}

	public void commitSession(Session appSession) {
		appSession.getTransaction().commit();
		appSession.close();
	}

	public void closeAppSessionFactory() {
		this.sessionFactory.close();
	}

}
