package com.contactsApp.contact;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("com.contactsApp.contact.repository")
@ComponentScan("com.contactsApp.contact.*;")
public class ContactApplication {


	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

}
