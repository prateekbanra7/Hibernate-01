package in.abc;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.abc.model.Student;
import in.abc.util.HibernateUtil;

public class GetRecordApp {

		public static void main(String[] args) {
			System.out.println(HibernateUtil.getSession());
			Session session = null;
			int id = 1;
			try {
				session = HibernateUtil.getSession();

				if (session != null) {
					Student student = session.get(Student.class, id);
					if (student != null)
						System.out.println(student);
					else
						System.out.println("Record not found for the given id :: "+id);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
			}

	}

}
