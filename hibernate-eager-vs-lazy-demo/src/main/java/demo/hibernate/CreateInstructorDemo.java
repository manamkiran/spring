package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			InstructorDetail instructorDetail = new InstructorDetail("MyTube", "Sleeping");

			Instructor instructor = new Instructor("kiran", "manam", "km@gmail.com");

			instructor.setInstructorDetail(instructorDetail);

			Course course1 = new Course("Java");
			Course course2 = new Course("Spring");
			Course course3 = new Course("Hibernate");
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			instructor.addCourse(course3);

			session.beginTransaction();

			session.save(instructor);
			session.save(course1);
			session.save(course2);
			session.save(course3);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
