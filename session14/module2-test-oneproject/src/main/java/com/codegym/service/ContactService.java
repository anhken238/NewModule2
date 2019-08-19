package com.codegym.service;

import com.codegym.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    Page<Contact> findAll(Pageable pageable);

    Contact findById(Long id);

    void save(Contact employee);

    void remove(Long id);

    Page<Contact> findAllByLastName( String lastName, Pageable pageable);
    Page<Contact> findContactByAdmin(String firstName, Pageable pageable);
    Page<Contact> findAllByLastNameContainingOrFirstNameContaining (String firstName,String lastName, Pageable pageable);

}
