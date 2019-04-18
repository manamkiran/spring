package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;
import demo.hibernate.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {


			session.beginTransaction();
			Course course = session.get(Course.class, 10);
			System.out.println(course);
			if(course!=null)
			{
				for (Review review : course.getReviews()) {
					System.out.println(review);
				}
			}
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
