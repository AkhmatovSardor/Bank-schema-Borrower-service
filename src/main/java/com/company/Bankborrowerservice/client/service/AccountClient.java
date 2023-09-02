package com.company.Bankborrowerservice.client.service;

import com.company.Bankborrowerservice.client.dto.AccountDto;
import com.company.Bankborrowerservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "account-service",path = "/account-service/account")
public interface AccountClient {
    @GetMapping("/get-by-loan/{id}")
    ResponseDto<Set<AccountDto>> getAccountByLoan(@PathVariable Integer id);
}
