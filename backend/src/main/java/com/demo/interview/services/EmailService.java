package com.demo.interview.services;

import com.demo.interview.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {
    private final EmailRepository emailRepository;
}
