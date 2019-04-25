package com.certiorem.workSelectorAlgoritm.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.certiorem.workSelectorAlgoritm.model.Candidate;
import com.certiorem.workSelectorAlgoritm.model.Company;
import com.certiorem.workSelectorAlgoritm.model.Offer;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://127.0.0.1:5432/jobselector");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "Pa$$w0rd");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL, "false");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Company.class);
				configuration.addAnnotatedClass(Offer.class);
				configuration.addAnnotatedClass(Candidate.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
