package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 6, max = 100)
    private String Name;

    @Size(min = 6, max = 50)
    private String sex;

    private Date dateOfBirth;

    private String phone;

    @Size(min = 6, max = 50)
    private String identityCard;

    private String email;

    @Size(min = 6, max = 50)
    private String address;

    @ManyToOne
    @JoinColumn(name = "employeegroup_id")
    private EmployeeGroup employeeGroup;

    public Employee() {
    }

    public Employee(@NotEmpty @Size(min = 6, max = 100) String name, @Size(min = 6, max = 50) String sex, Date dateOfBirth, String phone, String identityCard, String email, String address) {
        Name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.identityCard = identityCard;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }
}
