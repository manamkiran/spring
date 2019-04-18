package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			InstructorDetail instructorDetail = new InstructorDetail("MyTube", "Chess");
			
			Instructor instructor = new Instructor("vihaan", "manam", "vm@gmail.com");
			
			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
