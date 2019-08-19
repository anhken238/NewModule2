package com.codegym.service.impl;


import com.codegym.model.Contact;
import com.codegym.repository.ContactRepository;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Page<Contact> findAll(Pageable pageable) {

        pageable = new PageRequest(pageable.getPageNumber(), 5);
        return contactRepository.findAll(pageable);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void save(Contact employee) {
        contactRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        contactRepository.delete(id);
    }

    @Override
    public Page<Contact> findAllByLastName( String lastName, Pageable pageable) {
        return contactRepository.findAllByLastName ( lastName, pageable);
    }

    @Override
    public Page<Contact> findContactByAdmin(String firstName, Pageable pageable) {
        return contactRepository.findContactByAdmin(firstName,pageable );
    }

    @Override
    public Page<Contact> findAllByLastNameContainingOrFirstNameContaining(String firstName, String lastName, Pageable pageable) {
        return contactRepository.findAllByLastNameContainingOrFirstNameContaining(firstName, lastName, pageable);
    }
}
