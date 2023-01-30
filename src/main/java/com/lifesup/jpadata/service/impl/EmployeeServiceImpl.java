package com.lifesup.jpadata.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.lifesup.jpadata.model.Employee;
import com.lifesup.jpadata.repository.EmployeeRepository;
import com.lifesup.jpadata.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllWithFilter(String name, Integer age, String province, Pageable pageable) {
        return employeeRepository.findAllWithFilter(name, age, province, pageable);
    }
}
