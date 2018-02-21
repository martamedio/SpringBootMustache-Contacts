package com.me.service;

import com.me.App;
import com.me.entity.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ContactServiceTest {

    @Autowired
    private ContactServiceImpl contactService;

    @Test
    public void testSave() throws Exception {
        Contact contact = new Contact(null, "Test", "1098-098-0981");
        Contact savedContact = contactService.save(contact);

        assertNotNull(savedContact.getId());
        assertTrue(savedContact.getName().equals(contact.getName()));
        assertTrue(savedContact.getPhone().equals(contact.getPhone()));
        assertTrue(contactService.getAll().size() == 1);
    }

    @Test
    public void testFindById() {
        Contact contact = new Contact(null, "Test Delete", "1097-097-0971");
        Long id = contactService.save(contact).getId();
        Contact findContact = contactService.findById(id);

        assertNotNull(findContact);
    }


    @Test
    public void testDelete() {
        Contact contact = new Contact(null, "Test Delete", "1097-097-0971");
        Long id = contactService.save(contact).getId();
        contactService.delete(id);
        Contact findContact = contactService.findById(id);

        assertNull(findContact);
    }

}
