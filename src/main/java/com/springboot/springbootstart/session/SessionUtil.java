package com.springboot.springbootstart.session;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SessionUtil {
    @Autowired
    private SessionFactoryUtil sessionFactory;
    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void openTransaction() {
        session = openSession();
        transaction = session.beginTransaction();
    }

    public void closeTransaction() {
        transaction.commit();
        closeSession();
    }

    private Session openSession() {
        return sessionFactory.getSessionFactory().openSession();
    }

    private void closeSession() {
        session.close();
    }
}
