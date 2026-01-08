package com.example.springevodemo.scheduler;

import com.example.springevodemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MainScheduler {
    private final CustomerService customerService;

//    @Scheduled(fixedRate = 5000)
    public void run() {
//        customerService.getCustomers();
        System.out.println("Fixed rate task: " + LocalDateTime.now());
    }

}
