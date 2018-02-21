package com.me.service;

import com.me.controller.ContactController;
import com.me.dao.ContactDAO;
import com.me.entity.Contact;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl {

    final static Logger LOGGER = Logger.getLogger(ContactServiceImpl.class);

    private final ContactDAO contactDAO;

    public ContactServiceImpl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getAll() {
        return contactDAO.findAll();
    }

    public Contact save(Contact contact) {
        Contact savedContact = contactDAO.save(contact);
        LOGGER.info("New contact added: "+contact);
        return savedContact;
    }

    public void delete(Long id) {
        contactDAO.delete(id);
        LOGGER.info("Deleted contact with id: "+id);

    }

    public Contact findById(Long id) {
        Contact contact = contactDAO.findOne(id);
        LOGGER.info("Contact with id "+id+": "+contact);
        return contact;
    }
}
