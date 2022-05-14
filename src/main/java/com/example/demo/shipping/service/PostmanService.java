package com.example.demo.shipping.service;

import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.repository.PostmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostmanService {

    private final PostmanRepository postmanRepository;

    @Transactional(readOnly = true)
    public Long findAnyId() {
        return postmanRepository.findAll().stream().findAny().get().getId();
    }

    @Transactional
    public Postman save(Postman postman) {
        return postmanRepository.save(postman);
    }
}
