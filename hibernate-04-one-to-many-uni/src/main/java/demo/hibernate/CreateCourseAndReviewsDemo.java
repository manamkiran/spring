package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;
import demo.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			Course course = new Course("Spring");

			course.addReview(new Review("Nice Course"));
			course.addReview(new Review("Should have more advanced stuff"));
			course.addReview(new Review("Its Ok Ok"));

			session.beginTransaction();

			session.save(course);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
