package com.contactsApp.contact.controller;

import com.contactsApp.contact.Payload.ContactDTO;
import com.contactsApp.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
        System.out.println("post endpoint");
        ContactDTO createdContact = contactService.createContact(contactDTO);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable String contactId) {
        ContactDTO contactDTO = contactService.getContactById(contactId);
        if (contactDTO != null) {
            return new ResponseEntity<>(contactDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<ContactDTO>> searchContactsByName(@RequestParam String name) {
        List<ContactDTO> contacts = contactService.searchContactsByName(name);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/search/phonenumber")
    public ResponseEntity<List<ContactDTO>> searchContactsByPhoneNumber(@RequestParam String phoneNumber) {
        List<ContactDTO> contacts = contactService.searchContactsByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable String contactId, @RequestBody ContactDTO contactDTO) {
        ContactDTO updatedContact = contactService.updateContact(contactId, contactDTO);
        if (updatedContact != null) {
            return new ResponseEntity<>(updatedContact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable String contactId) {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}