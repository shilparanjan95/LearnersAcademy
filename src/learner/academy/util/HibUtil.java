package learner.academy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration config = new Configuration();
				config.configure();
				sessionFactory = config.buildSessionFactory();
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("exception in creating sessionFactory object");
		}
		return sessionFactory;

	}
}
