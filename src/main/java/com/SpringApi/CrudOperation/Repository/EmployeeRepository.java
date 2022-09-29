package com.SpringApi.CrudOperation.Repository;

import com.SpringApi.CrudOperation.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

}
