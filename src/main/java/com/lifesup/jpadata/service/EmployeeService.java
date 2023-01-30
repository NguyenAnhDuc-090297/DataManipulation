package com.lifesup.jpadata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.lifesup.jpadata.model.Employee;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllWithFilter(String name, Integer age, String province, Pageable pageable);
}
