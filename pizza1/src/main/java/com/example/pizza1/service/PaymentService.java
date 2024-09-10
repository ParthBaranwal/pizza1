package com.example.pizza1.service;

import com.example.pizza1.dto.PaymentRequest;
import com.example.pizza1.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class PaymentService {


    public PaymentResponse processPayment(PaymentRequest request) {

        String[] statuses = {"SUCCESS", "FAILED", "IN_PROGRESS"};
        String status = statuses[new Random().nextInt(statuses.length)];



        String message = switch (status) {
            case "SUCCESS" -> "Payment processed successfully.";
            case "FAILED" -> "Payment failed. Please try again.";
            default -> "Payment is in progress.";
        };

        return new PaymentResponse(status, message);
    }
}
