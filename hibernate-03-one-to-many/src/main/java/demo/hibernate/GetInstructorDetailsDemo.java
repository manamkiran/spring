package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class GetInstructorDetailsDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);

			System.out.println(instructorDetail);
			if (instructorDetail != null) {

				System.out.println(instructorDetail.getInstructor());

			}

			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
