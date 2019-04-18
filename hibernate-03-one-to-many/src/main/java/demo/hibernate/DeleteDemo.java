package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);

			System.out.println(instructor);
			if (instructor != null) {

				session.delete(instructor);

			}
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
