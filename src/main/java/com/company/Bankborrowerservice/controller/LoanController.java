package com.company.Bankborrowerservice.controller;

import com.company.Bankborrowerservice.dto.LoanDto;
import com.company.Bankborrowerservice.dto.ResponseDto;
import com.company.Bankborrowerservice.service.LoanService;
import com.company.Bankborrowerservice.util.SimpleCrud;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("loaner")
@RequiredArgsConstructor
@Slf4j
@RateLimiter(name = "first-rate-limiter",fallbackMethod = "fallBack")
public class LoanController implements SimpleCrud<Integer, LoanDto> {
    private final LoanService loanService;

    @PostMapping("/create")
    @Override
    @Operation(
            tags = "Create",
            summary = "Your summary create loan method!",
            description = "This is method for create loan!",
            responses = @ApiResponse(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = LoanDto.class
                            )
                    )
            )
    )
    public ResponseDto<LoanDto> create(@Valid @RequestBody LoanDto dto) {
        return this.loanService.create(dto);
    }

    @GetMapping("/get/{id}")
    @Override
    @Operation(
            tags = "Get",
            summary = "Your summary get by loan method!",
            description = "This is method for get loan!"
    )
    public ResponseDto<LoanDto> get(@PathVariable(value = "id") Integer id) {
        return this.loanService.get(id);
    }
    @GetMapping("/get-with-account/{id}")
    @Operation(
            tags = "Get",
            summary = "Your summary get-with-account method!",
            description = "This is method for get loan!"
    )
    public ResponseDto<LoanDto> getWithAccount(@PathVariable(value = "id") Integer id) {
        return this.loanService.getWithAccount(id);
    }
    @GetMapping("/get-with-payment/{id}")
    @Operation(
            tags = "Get",
            summary = "Your summary get-with-payment method!",
            description = "This is method for get loan!"
    )
    public ResponseDto<LoanDto> getWithPayment(@PathVariable(value = "id") Integer id) {
        return this.loanService.getWithPayment(id);
    }


    @PutMapping("/update/{id}")
    @Override
    @Operation(
            tags = "Update",
            summary = "Your summary update loan method!",
            description = "This is method for update loan!",
            responses = @ApiResponse(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = LoanDto.class
                            )
                    )
            )
    )
    public ResponseDto<LoanDto> update(@PathVariable(value = "id") Integer id, @RequestBody LoanDto dto) {
        return this.loanService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    @Operation(
            tags = "Delete",
            summary = "Your summary delete by loan method!",
            description = "This is method for delete loan!"
    )
    public ResponseDto<LoanDto> delete(@PathVariable(value = "id") Integer id) {
        return this.loanService.delete(id);
    }
    public ResponseDto<LoanDto> fallBack(Exception e){
        log.warn("inti fallBack method");
        return ResponseDto.<LoanDto>builder()
                .message("inti fallBack method")
                .build();
    }
}
