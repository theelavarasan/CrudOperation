package com.SpringApi.CrudOperation.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;
}
