package com.example.demo.security;

import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.entity.Sender;
import com.example.demo.shipping.repository.PostmanRepository;
import com.example.demo.shipping.repository.SenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationService {

    private final PostmanRepository postmanRepository;
    private final SenderRepository senderRepository;

    public Postman postman() {
        return postmanRepository.findPostmanById(user().getUserId()).orElseThrow(RuntimeException::new);
    }

    public Sender sender() {
        return senderRepository.findSenderById(user().getUserId()).orElseThrow(RuntimeException::new);
    }

    public User user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            return (User) principal;
        }

        throw new RuntimeException();
    }
}
