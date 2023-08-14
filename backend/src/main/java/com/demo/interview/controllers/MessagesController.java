package com.demo.interview.controllers;

import com.demo.interview.entites.Email;
import com.demo.interview.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    EmailRepository emailRepository;

    @GetMapping("/emails")
    public ResponseEntity<List<Email>> messages( ) {
        List<Email> emails =  emailRepository.findAll();
        return ResponseEntity.ok(emails);
    }

    @PostMapping("/saveEmail")
    public ResponseEntity<List<Email>> saveEmail(@RequestBody Email email) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        email.date = dateFormat.format(date);
        emailRepository.save(email);
        List<Email> emails = emailRepository.findAll();
        return ResponseEntity.ok(emails);
    }
}
