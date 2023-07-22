package com.contactsApp.contact.service;

import com.contactsApp.contact.Payload.ContactDTO;


import java.util.List;


public interface ContactService {
     ContactDTO createContact(ContactDTO contactDTO);
     ContactDTO getContactById(String contactId);
     List<ContactDTO> searchContactsByName(String name);
     List<ContactDTO> searchContactsByPhoneNumber(String phoneNumber);
     ContactDTO updateContact(String contactId, ContactDTO contactDTO);
     void deleteContact(String contactId);
}
