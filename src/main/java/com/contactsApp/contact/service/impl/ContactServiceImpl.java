package com.contactsApp.contact.service.impl;

import com.contactsApp.contact.Payload.ContactDTO;
import com.contactsApp.contact.entity.Contact;
import com.contactsApp.contact.repository.ContactRepository;
import com.contactsApp.contact.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contact = contactRepository.save(contact);
        return modelMapper.map(contact, ContactDTO.class);
    }

    @Override
    public ContactDTO getContactById(String contactId) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        return optionalContact.map(contact -> modelMapper.map(contact, ContactDTO.class)).orElse(null);
    }

    @Override
    public List<ContactDTO> searchContactsByName(String name) {
        List<Contact> contacts = contactRepository.findAllByFirstNameIgnoreCaseContaining(name);
        return contacts.stream().map(contact -> modelMapper.map(contact, ContactDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> searchContactsByPhoneNumber(String phoneNumber) {
        List<Contact> contacts = contactRepository.findAllByPhoneNumbersContaining(phoneNumber);
        return contacts.stream().map(contact -> modelMapper.map(contact, ContactDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ContactDTO updateContact(String contactId, ContactDTO contactDTO) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            existingContact.setFirstName(contactDTO.getFirstName());
            existingContact.setLastName(contactDTO.getLastName());
            existingContact.setEmail(contactDTO.getEmail());
            existingContact.setPhoneNumbers(contactDTO.getPhoneNumbers());
            existingContact = contactRepository.save(existingContact);
            return modelMapper.map(existingContact, ContactDTO.class);
        }
        return null;
    }

    @Override
    public void deleteContact(String contactId) {
        contactRepository.deleteById(contactId);
    }
}