package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Course;
import demo.hibernate.entity.Instructor;
import demo.hibernate.entity.InstructorDetail;
import demo.hibernate.entity.Review;
import demo.hibernate.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			Course course1 = new Course("Spring");

			Course course2 = new Course("Hibernate");

			Student student1 = new Student("kiran", "manam", "km@gmail.com");
			Student student2 = new Student("priya", "bany", "pb@gmail.com");

			course1.addStudent(student1);
			course1.addStudent(student2);
			course2.addStudent(student1);

			session.beginTransaction();

			session.save(course1);
			session.save(course2);
			session.save(student1);
			session.save(student2);

			session.getTransaction().commit();

			System.out.println(course1.getStudents());
			System.out.println(course2.getStudents());

		} finally {
			sessionFactory.close();
		}
	}

}
