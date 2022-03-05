package com.crm.crm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(path = "/contacts")
    public List<Contact> getContacts() {
        return (List<Contact>) this.contactRepository.findAll();
    }

    @PostMapping(path = "/contacts")
    public ResponseEntity<Contact> addContact(@Validated @RequestBody Contact contact) throws URISyntaxException {
        Contact res = contactRepository.save(contact);
        return ResponseEntity.ok().body(res);
    }
}
