package com.user.contact.contactservice.services;

import com.user.contact.contactservice.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getContactsOfUserId(Long userId);
}
