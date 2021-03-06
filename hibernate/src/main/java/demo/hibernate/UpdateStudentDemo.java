package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			
			student.setLastName("Manam");
			
			session.createQuery("update Student set lastName='M' where id=1").executeUpdate();
			
			session.getTransaction().commit();

			System.out.println(student);
		} finally {
			sessionFactory.close();
		}
	}

}
