package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			/*
			 * session.beginTransaction();
			 * 
			 * session.save(student);
			 * 
			 * session.getTransaction().commit();
			 */

			session.beginTransaction();

			Student student = session.get(Student.class, 6);

			session.delete(student);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
