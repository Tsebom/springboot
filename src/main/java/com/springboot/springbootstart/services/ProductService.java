package com.springboot.springbootstart.services;

import com.springboot.springbootstart.dao.ProductDao;
import com.springboot.springbootstart.entity.Product;
import com.springboot.springbootstart.session.SessionUtil;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductService implements ProductDao {
    @Autowired
    private SessionUtil sessionUtil;
    @Override
    public Product saveOrUpdate(Product product) {
        sessionUtil.openTransaction();
        sessionUtil.getSession().saveOrUpdate(product);
        sessionUtil.closeTransaction();
        return product;
    }

    @Override
    public Product findById(Long id) {
        sessionUtil.openTransaction();
        Query query = sessionUtil.getSession().createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();
        sessionUtil.closeTransaction();
        return product;
    }

    @Override
    public List<Product> findAll() {
        sessionUtil.openTransaction();
        List<Product> products = sessionUtil.getSession().createNamedQuery("Product.findAll", Product.class).getResultList();
        sessionUtil.closeTransaction();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        sessionUtil.openTransaction();
        sessionUtil.getSession().remove(sessionUtil.getSession().find(Product.class, id));
        sessionUtil.closeTransaction();
    }
}