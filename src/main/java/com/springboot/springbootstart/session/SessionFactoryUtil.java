package com.springboot.springbootstart.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtil {
    private final SessionFactory sessionFactory;

    public SessionFactoryUtil() {
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutDown() {
        sessionFactory.close();
    }
}
