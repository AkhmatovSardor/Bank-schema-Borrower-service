package com.company.Bankborrowerservice.client.service;

import com.company.Bankborrowerservice.client.dto.PaymentDto;
import com.company.Bankborrowerservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service",path = "/payment-service/payment")
public interface PaymentClient {
    @GetMapping("/get-by-loan/{id}")
    ResponseDto<PaymentDto> getPaymentByLoan(@PathVariable(value = "id") Integer id);
}
