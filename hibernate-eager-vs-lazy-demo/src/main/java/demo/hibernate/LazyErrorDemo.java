package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class LazyErrorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 1);

			System.out.println("Instructor " + instructor);

			session.getTransaction().commit();

			session.close();
			
			if (instructor != null) {
				System.out.println("Courses" + instructor.getCourses());
			}

		} finally {
			sessionFactory.close();
		}
	}

}
