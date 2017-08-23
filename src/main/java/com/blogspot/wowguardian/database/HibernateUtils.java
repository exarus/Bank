package com.blogspot.wowguardian.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Utils to use Hibernate.
 * Created by User on 20.07.2014.
 */
public class HibernateUtils {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        //   configuration.configure("/xmlconf/hibernate.cfg.xml");
        configuration.configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
