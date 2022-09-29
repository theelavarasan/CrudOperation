package com.SpringApi.CrudOperation.Service;

import com.SpringApi.CrudOperation.Dto.EmployeeDto;
import com.SpringApi.CrudOperation.Entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeServiceImpl {
    Employee createEmployee(Employee employee);

    List<Employee> getAll();

    ResponseEntity<String> deleteAll();

    ResponseEntity<String> deleteById(Long id);

    Employee updateById(Long id, Employee employee);

    ResponseEntity<Object> getById(Long id);
}
