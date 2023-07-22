package com.contactsApp.contact.repository;

import com.contactsApp.contact.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findAllByFirstNameIgnoreCaseContaining(String firstName);
    List<Contact> findAllByPhoneNumbersContaining(String phoneNumber);
}
