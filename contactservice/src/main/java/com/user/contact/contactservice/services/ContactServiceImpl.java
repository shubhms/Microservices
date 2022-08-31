package com.user.contact.contactservice.services;

import com.user.contact.contactservice.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    //fake list of contacts (Ideally should be fetched from Database)
    List<Contact> contactList = List.of(
            new Contact(12L, "abc@gmail.com", "Ghanshyam", 115L),
            new Contact(13L, "qwe@gmail.com", "Rahul", 115L),
            new Contact(14L, "xyz@gmail.com", "Parvati", 116L),
            new Contact(17L, "dfg@gmail.com", "Sarla", 116L),
            new Contact(19L, "bgf@gmail.com", "Manoj", 116L),
            new Contact(22L, "jkj@gmail.com", "Ali", 117L)
    );

    @Override
    public List<Contact> getContactsOfUserId(Long userId) {
        return contactList.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
