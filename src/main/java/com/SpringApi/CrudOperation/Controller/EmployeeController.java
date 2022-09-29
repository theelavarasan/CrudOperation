package com.SpringApi.CrudOperation.Controller;

import com.SpringApi.CrudOperation.Entity.Employee;
import com.SpringApi.CrudOperation.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object>getById(@PathVariable Long id){
        return service.getById(id);
    }


    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        return service.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateById(@PathVariable Long id, @RequestBody Employee employee){
        return service.updateById(id,employee);
    }



}
