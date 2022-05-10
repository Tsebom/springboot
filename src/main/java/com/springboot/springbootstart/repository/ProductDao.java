package com.springboot.springbootstart.repository;

import com.springboot.springbootstart.model.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductDao {
    EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    EntityManager entityManager = factory.createEntityManager();

    public Product saveOrYUpdate(Product product) {
        if (entityManager.contains(product)) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
        return product;
    }

    public Product findById(int id) {
        Product product = entityManager.createNamedQuery("Product.findById", Product.class).getSingleResult();
        return product;
    }

    public List<Product> findAll() {
        List<Product> products = entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
        return products;
    }

    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
