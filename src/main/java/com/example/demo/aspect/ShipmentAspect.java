package com.example.demo.aspect;

import com.example.demo.security.AuthenticationService;
import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.entity.Sender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@RequiredArgsConstructor
@Component
public class ShipmentAspect {

    private final AuthenticationService authenticationService;

    @After("execution(* com.example.demo.shipping.service.ShipmentService.save(..))")
    public void saveShipmentPointCut(JoinPoint joinPoint) {
        Sender sender = authenticationService.sender();
        log.info("New shipment created! -> Sender : " + sender.fullName());
    }

    @After("execution(* com.example.demo.shipping.service.ShipmentService.retrieveShipmentsByPostmanId(..))")
    public void retrieveShipmentPointCut(JoinPoint joinPoint) {
        Postman postman = authenticationService.postman();
        log.info("All shipments retrieved! -> Postman : " + postman.fullName());
    }
}
