package com.codegym.repository;

import com.codegym.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends PagingAndSortingRepository <Contact, Long> {
    Page<Contact> findAllByLastName (String lastName, Pageable pageable);

    @Query(value = "SELECT c FROM Contact c  WHERE c.firstName =:firstName ")
    Page<Contact> findContactByAdmin (@Param("firstName") String firstName, Pageable pageable);

    Page<Contact> findAllByLastNameContainingOrFirstNameContaining (String firstName,String lastName, Pageable pageable);
}
