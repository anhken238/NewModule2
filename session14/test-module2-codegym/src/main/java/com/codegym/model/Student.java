package com.codegym.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(max = 5)
    @Column(unique = true)
    @Pattern(regexp = "(HS)+([0-9]{3})", message = "Start with two characters hs and the following 3 characters are numbers")
    private String code;

    @NotEmpty
    @Size(min = 5, max = 60)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 60)
    private String classStudent;

    @Size(min = 6, max = 50)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date dateBorrow;


    @NotEmpty
    @Pattern(regexp = "(09|08|03)+([0-9]{8,12})", message = "Only entered numbers and between 7 and 12, the beginning of the number 03,08,09")
    private String phone;


    @NotEmpty
    @Email(message="Email does not format")
    private String email;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Book book;

    public Student() {
    }

    public Student(@NotEmpty @Size(max = 5) @Pattern(regexp = "(HS)+([0-9]{3})", message = "The first 2 characters are HS letters The next 3 characters are numbers") String code, @NotEmpty @Size(min = 5, max = 60) String name, @NotEmpty @Size(min = 5, max = 60) String classStudent, @Size(min = 6, max = 50) String address, Date dateCreate, Date dateBorrow, @NotEmpty @Pattern(regexp = "(09|08|03)+([0-9]{8,12})", message = "Only entered numbers and between 7 and 12, the beginning of the number 03,08,09") String phone, @NotEmpty @Email(message = "Email does not format") String email) {
        this.code = code;
        this.name = name;
        this.classStudent = classStudent;
        this.address = address;
        this.dateCreate = dateCreate;
        this.dateBorrow = dateBorrow;
        this.phone = phone;
        this.email = email;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
