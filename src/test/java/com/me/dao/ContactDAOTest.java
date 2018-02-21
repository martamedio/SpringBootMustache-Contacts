package com.me.dao;

import com.me.entity.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContactDAOTest {

    @Autowired
    ContactDAO repository;

    @Test
    public void testSave() throws Exception {
        Contact contact = new Contact(null, "Test", "1098-098-0981");
        Contact savedContact = repository.save(contact);

        assertNotNull(savedContact.getId());
        assertTrue(savedContact.getName().equals(contact.getName()));
        assertTrue(savedContact.getPhone().equals(contact.getPhone()));
        assertTrue(repository.findAll().size() == 1);
    }

    @Test
    public void testDelete() {

        Contact contact = new Contact(null, "Test Delete", "1097-097-0971");
        Long id = repository.save(contact).getId();
        repository.delete(id);
        Contact findContact = repository.findOne(id);
        assertNull(findContact);
    }
}
