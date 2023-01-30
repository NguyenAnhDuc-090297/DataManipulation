package com.lifesup.jpadata.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lifesup.jpadata.constant.SqlConstant;
import com.lifesup.jpadata.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = SqlConstant.FIND_ALL_WITH_FILTER)
    Page<Employee> findAllWithFilter(String name, Integer age, String province, Pageable pageable);
}