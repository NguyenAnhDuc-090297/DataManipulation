package com.lifesup.jpadata.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lifesup.jpadata.common.CustomSort;
import com.lifesup.jpadata.dto.EmployeeDto;
import com.lifesup.jpadata.model.Employee;
import com.lifesup.jpadata.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-all")
    public Page<Employee> getEmployee(@RequestBody EmployeeDto request) {

        List<CustomSort> sort = request.getSort();
        List<Order> orders = new ArrayList<>();
        sort.forEach(customSort -> {
            if ("name".equals(customSort.getField())) {
                Order nameOrder;
                if ("asc".equals(customSort.getDirection())) {
                    nameOrder = new Order(Direction.ASC, "name");
                } else {
                    nameOrder = new Order(Direction.DESC, "name");
                }
                orders.add(nameOrder);
            }
            if ("age".equals(customSort.getField())) {
                Order ageOrder;
                if ("asc".equals(customSort.getDirection())) {
                    ageOrder = new Order(Direction.ASC, "age");
                } else {
                    ageOrder = new Order(Direction.DESC, "age");
                }
                orders.add(ageOrder);
            }
            if ("province".equals(customSort.getField())) {
                Order provinceOrder;
                if ("asc".equals(customSort.getDirection())) {
                    provinceOrder = new Order(Direction.ASC, "age");
                } else {
                    provinceOrder = new Order(Direction.DESC, "age");
                }
                orders.add(provinceOrder);
            }
        });
        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), Sort.by(orders));
        String nameFilter = request.getName() != null ? request.getName() : "";
        Integer ageFilter = request.getAge() != null ? request.getAge() : -1;
        String provinceFilter = request.getProvince() != null ? request.getProvince() : "";
        return employeeService.findAllWithFilter(nameFilter, ageFilter, provinceFilter, pageable);
    }
}
