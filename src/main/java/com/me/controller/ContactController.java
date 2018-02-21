package com.me.controller;

import com.me.entity.Contact;
import com.me.service.ContactServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ContactController {

    final static Logger LOGGER = Logger.getLogger(ContactController.class);

    private final String TEMPLATE_NAME = "contacts";
    private final String TEMPLATE_DATA = "contactList";

    private final ContactServiceImpl contactService;

    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String getContacts(Map<String, Object> modelMap) {
        modelMap.put(TEMPLATE_DATA, contactService.getAll());
        LOGGER.info("Printing view: "+TEMPLATE_NAME);
        return TEMPLATE_NAME;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Contact contact, Map<String, Object> modelMap) throws Exception {
        LOGGER.info("Adding Contact: "+contact);
        contactService.save(contact);
        return getContacts(modelMap);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> modelMap) throws Exception {
        LOGGER.info("Deleting Contact with id: "+id);
        contactService.delete(id);
        return getContacts(modelMap);
    }
}
