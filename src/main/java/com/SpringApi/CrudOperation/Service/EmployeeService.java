package com.SpringApi.CrudOperation.Service;

import com.SpringApi.CrudOperation.Dto.EmployeeDto;
import com.SpringApi.CrudOperation.Dto.GenericDTO;
import com.SpringApi.CrudOperation.Entity.Employee;
import com.SpringApi.CrudOperation.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class EmployeeService implements EmployeeServiceImpl{
    @Autowired
    private EmployeeRepository repository;


    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }


    @Override
    public ResponseEntity<String> deleteAll() {
        repository.deleteAll();
        return new ResponseEntity<String>("All Employees Deleted Succesfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        repository.deleteById(id);
        return new ResponseEntity<String>("The "+ id + " has Deleted Succesfully", HttpStatus.OK);
    }

    @Override
    public Employee updateById(Long id, Employee employee) {
        Optional<Employee> employee1 = repository.findById(id);
        Employee employee2 = employee1.get();
        employee2.setId(employee.getId());
        employee2.setFirstName(employee.getFirstName());
        employee2.setLastName(employee.getLastName());
        employee2.setEmailId(employee.getEmailId());
        employee2.setPhoneNo(employee.getPhoneNo());
        return repository.save(employee2);
    }

//    @Override
//    public ResponseEntity<Object> updateById(Long id, EmployeeDto dto) {
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setAmbiguityIgnored(true);
//        Employee employee = mapper.map(dto,Employee.class);
//        GenericDTO dto1= new GenericDTO();
//        dto1.setObject(employee);
//        dto1.setMessage("Given " + id + " Id has updated Successfully");
//        repository.save(employee);
//        return new ResponseEntity<Object>(dto,HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<Object> getById(Long id) {
        Optional<Employee> employee=repository.findById(id);
        GenericDTO dto= new GenericDTO();
        dto.setObject(employee);
        dto.setMessage("Your " + id + " Id details shown Above");
        if(employee.isPresent()){
            return new ResponseEntity<Object>(dto,HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
