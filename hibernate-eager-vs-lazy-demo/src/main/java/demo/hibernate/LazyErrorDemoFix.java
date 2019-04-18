package demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class LazyErrorDemoFix {

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

			// fix 1 load the courses while in session for later use.
			// DO note just calling instructor.getCourses() doesn't work as the variable is not accessed
			// and thus hibernate doesn't load it.

			System.out.println(instructor.getCourses());

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
