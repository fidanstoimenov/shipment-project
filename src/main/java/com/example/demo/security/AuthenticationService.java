package com.example.demo.security;

import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.entity.Sender;
import com.example.demo.shipping.repository.PostmanRepository;
import com.example.demo.shipping.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    @Autowired
    private PostmanRepository postmanRepository;

    @Autowired
    private SenderRepository senderRepository;

    public Postman postman() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            User user = (User) principal;
            return postmanRepository.findPostmanById(user.getUserId()).orElseThrow(RuntimeException::new);
        }

        throw new RuntimeException();
    }

    public Sender sender() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            User user = (User) principal;
            return senderRepository.findSenderById(user.getUserId()).orElseThrow(RuntimeException::new);
        }

        throw new RuntimeException();
    }

}
