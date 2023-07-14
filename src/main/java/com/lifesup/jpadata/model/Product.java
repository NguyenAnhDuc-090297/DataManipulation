package com.lifesup.jpadata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "test")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    private String name;

    @Column(name = "qty_available")
    private Integer quantity;

    private String description;

    private Double price;

    @Column(name = "category_id")
    private Long categoryId;
}
