package com.company.Bankborrowerservice.controller;

import com.company.Bankborrowerservice.dto.BorrowerDto;
import com.company.Bankborrowerservice.dto.LoanDto;
import com.company.Bankborrowerservice.dto.ResponseDto;
import com.company.Bankborrowerservice.service.BorrowerService;
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
@RequestMapping("borrower")
@RequiredArgsConstructor
@Slf4j
@RateLimiter(name = "first-rate-limiter", fallbackMethod = "fallBack")
public class BorrowerController implements SimpleCrud<Integer, BorrowerDto> {
    private final BorrowerService borrowerService;
    private final LoanService loanService;

    @PostMapping("/create")
    @Override
    @Operation(
            tags = "Create",
            summary = "Your summary create borrower method!",
            description = "This is method for create borrower!",
            responses = @ApiResponse(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BorrowerDto.class
                            )
                    )
            )
    )
    public ResponseDto<BorrowerDto> create(@Valid @RequestBody BorrowerDto dto) {
        return this.borrowerService.create(dto);
    }

    @GetMapping("/get-by-branch/{id}")
    @Operation(
            tags = "Get",
            summary = "Your summary get loan by branch method!",
            description = "This is method for get loan!"
    )
    public ResponseDto<Set<LoanDto>> getLoanByBranch(@PathVariable(value = "id") Integer id) {
        return loanService.getLoanByBranch(id);
    }

    @GetMapping("/get/{id}")
    @Override
    @Operation(
            tags = "Get",
            summary = "Your summary get by borrower method!",
            description = "This is method for get borrower!"
    )
    public ResponseDto<BorrowerDto> get(@PathVariable(value = "id") Integer id) {
        return this.borrowerService.get(id);
    }

    @GetMapping("/get-by-customer/{id}")
    @Operation(
            tags = "Get",
            summary = "Your summary get by-customer borrower method!",
            description = "This is method for get borrower!"
    )
    public ResponseDto<BorrowerDto> getByCustomer(@PathVariable(value = "id") Integer id) {
        return this.borrowerService.getByCustomer(id);
    }

    @GetMapping("/get-with-loan/{id}")
    @Operation(
            tags = "Get",
            summary = "Your summary get by-with-loan borrower method!",
            description = "This is method for get borrower!"
    )
    public ResponseDto<BorrowerDto> getWithLoan(@PathVariable(value = "id") Integer id) {
        return this.borrowerService.getWithLoan(id);
    }

    @PutMapping("/update/{id}")
    @Override
    @Operation(
            tags = "Update",
            summary = "Your summary update borrower method!",
            description = "This is method for update borrower!",
            responses = @ApiResponse(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BorrowerDto.class
                            )
                    )
            )
    )
    public ResponseDto<BorrowerDto> update(@PathVariable(value = "id") Integer id, @RequestBody BorrowerDto dto) {
        return this.borrowerService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    @Operation(
            tags = "Delete",
            summary = "Your summary delete by borrower method!",
            description = "This is method for delete borrower!"
    )
    public ResponseDto<BorrowerDto> delete(@PathVariable(value = "id") Integer id) {
        return this.borrowerService.delete(id);
    }

    public ResponseDto<BorrowerDto> fallBack(Exception e) {
        log.warn("inti fallBack method");
        return ResponseDto.<BorrowerDto>builder()
                .message("inti fallBack method")
                .build();
    }
}
