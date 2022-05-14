package com.example.demo.shipping.service;

import com.example.demo.shipping.entity.Sender;
import com.example.demo.shipping.repository.SenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SenderService {

    private final SenderRepository senderRepository;

    @Transactional
    public Sender save(Sender sender) {
        return senderRepository.save(sender);
    }
}
