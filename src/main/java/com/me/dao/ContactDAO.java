package com.me.dao;

import com.me.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDAO extends JpaRepository<Contact, Long> {
}
