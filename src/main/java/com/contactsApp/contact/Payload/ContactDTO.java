package com.contactsApp.contact.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNumbers;
}