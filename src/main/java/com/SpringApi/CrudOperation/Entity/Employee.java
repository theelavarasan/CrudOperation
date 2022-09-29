package com.SpringApi.CrudOperation.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Employee_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Email_Id")
    private String emailId;
    @Column(name = "Phone_No")
    private String phoneNo;
}
