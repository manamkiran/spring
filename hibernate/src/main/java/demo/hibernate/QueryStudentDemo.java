package demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList();

			printStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName='manam'", Student.class).getResultList();

			System.out.println("\n\nStudent with last Name Manam");
			printStudents(theStudents);

			theStudents = session
					.createQuery("from Student s where s.lastName='manam' OR s.firstName='Priya'", Student.class)
					.getResultList();
			
			System.out.println("\n\nStudent with last Name Manam or first Name Priya");
			printStudents(theStudents);
			
			theStudents = session
					.createQuery("from Student s where s.email like '%gmail.com'", Student.class)
					.getResultList();
			
			System.out.println("\n\nStudent with gmail as a email");
			printStudents(theStudents);
			
			theStudents = session
					.createQuery("from Student s where s.email like '%yahoo.com'", Student.class)
					.getResultList();
			
			System.out.println("\n\nStudent with yahoo as a email");
			printStudents(theStudents);


			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

	private static void printStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
