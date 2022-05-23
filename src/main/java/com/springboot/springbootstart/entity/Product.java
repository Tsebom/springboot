package com.springboot.springbootstart.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`products`")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT product FROM Product product"),
        @NamedQuery(name = "Product.findById", query = "SELECT product FROM Product product WHERE product.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private double cost;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }
}
