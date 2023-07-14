package com.lifesup.jpadata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Category {

    @Id
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    private String categoryType;

}
