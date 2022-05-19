package com.springboot.springbootstart.services;

import com.springboot.springbootstart.dao.CustomerDao;
import com.springboot.springbootstart.entity.Customer;
import com.springboot.springbootstart.session.SessionUtil;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerService implements CustomerDao {

    @Autowired
    private SessionUtil sessionUtil;
    @Override
    public Customer saveOrUpdate(Customer customer) {
        sessionUtil.openTransaction();
        sessionUtil.getSession().saveOrUpdate(customer);
        sessionUtil.closeTransaction();
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        sessionUtil.openTransaction();
        Query query = sessionUtil.getSession().createNamedQuery("Customer.findById", Customer.class);
        query.setParameter("id", id);
        Customer customer = (Customer) query.getSingleResult();
        sessionUtil.closeTransaction();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        sessionUtil.openTransaction();
        List<Customer> customers = sessionUtil.getSession().createNamedQuery("Customer.findAll", Customer.class).getResultList();
        sessionUtil.closeTransaction();
        return customers;
    }

    @Override
    public void deleteById(Long id) {
        sessionUtil.openTransaction();
        sessionUtil.getSession().remove(sessionUtil.getSession().find(Customer.class, id));
        sessionUtil.closeTransaction();
    }
}
