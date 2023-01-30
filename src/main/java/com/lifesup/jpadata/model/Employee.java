package com.lifesup.jpadata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Integer age;

    private String province;
}
