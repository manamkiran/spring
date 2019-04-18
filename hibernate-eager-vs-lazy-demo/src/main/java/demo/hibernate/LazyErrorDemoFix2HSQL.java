package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class LazyErrorDemoFix2HSQL {

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

			// fix 2 : Hibernate query with HQL

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

			query.setParameter("theInstructorId", 1);
			
			Instructor temp = query.getSingleResult();
			
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
