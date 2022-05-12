package com.springboot.springbootstart.servises;

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
        if (product.getId() != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        }
        return product;
    }

    public Product findById(Long id) {
        Product product = entityManager.createNamedQuery("Product.findById", Product.class).getSingleResult();
        return product;
    }

    public List<Product> findAll() {
        List<Product> products = entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
        return products;
    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class, id));
        entityManager.getTransaction().commit();
    }
}
