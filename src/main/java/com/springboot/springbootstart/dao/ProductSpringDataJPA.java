package com.springboot.springbootstart.dao;

import com.springboot.springbootstart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSpringDataJPA extends JpaRepository<Product, Long> {
    List<Product> findByCostBetween(Double min, Double max);
    List<Product> findByCostLessThanEqual(Double max);
    List<Product> findByCostGreaterThanEqual(Double max);
}