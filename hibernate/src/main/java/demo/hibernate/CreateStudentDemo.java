package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			Student student = new Student("ratnam", "manam", "rm@gmail.com");

			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
