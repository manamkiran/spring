package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			session.save(new Student("Vihaan", "M", "vm@gmail.com"));
			session.save(new Student("Priya", "B", "pb@gmail.com"));
			session.save(new Student("Chandra", "K", "ck@gmail.com"));

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
