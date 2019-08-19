package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 100, message = "length from 1-100")
    private String firstName;

    @NotEmpty
    @Size(min = 1, max = 100, message = "length from 1-100")
    private String lastName;



    @NotEmpty(message=" phone is not empty")
    @Pattern(regexp = "(09|08|03)+([0-9]{8})" , message = "first number start : 09|08|03 ")
    private String phone;

    @Column(unique = true)
    @NotEmpty(message="Email not empty")
    @Size(max = 100)
    @Email(message="Email does not the correct format")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 100, message = "length from 3-100")
    private String address;

    public Contact() {
    }

    public Contact(@NotEmpty @Size(min = 1, max = 100, message = "length from 1-100") String firstName, @NotEmpty @Size(min = 1, max = 100, message = "length from 1-100") String lastName, @NotEmpty(message = "Điện thoại không được để trống!") @Pattern(regexp = "(09|08|03)+([0-9]{8})") String phone, @NotEmpty(message = "Email không được để trống!") @Email(message = "Email does not the correct format") String email, @NotEmpty @Size(min = 3, max = 100, message = "length from 3-100") String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
