package com.company.Bankborrowerservice.service.mapper;

import com.company.Bankborrowerservice.client.service.AccountClient;
import com.company.Bankborrowerservice.client.service.PaymentClient;
import com.company.Bankborrowerservice.dto.LoanDto;
import com.company.Bankborrowerservice.entity.Loan;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class})
public abstract class LoanMapper {
    @Autowired
    protected AccountClient accountClient;
    @Autowired
    protected PaymentClient paymentClient;

    @Mapping(target = "payment", ignore = true)
    @Mapping(target = "account", ignore = true)
    public abstract LoanDto toDto(Loan loan);

    //  @Mapping(target = "payment",expression = "java(this.paymentMapper.toDto(loan.getPayment()))")
    // @Mapping(target = "account",expression = "java(loan.getAccount().stream().map(this.accountMapper::toDto).collect(Collectors.toSet()))")

    @Mapping(target = "loanId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Loan toEntity(LoanDto dto);

    @Mapping(target = "loanId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Loan loan, LoanDto dto);

    @Mapping(target = "account", expression = "java(accountClient.getAccountByLoan(loan.getLoanId()).getData())")
    @Mapping(target = "payment", ignore = true)
    public abstract LoanDto toDtoWithAccount(Loan loan);

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "payment", expression = "java(paymentClient.getPaymentByLoan(loan.getLoanId()).getData())")
    public abstract LoanDto toDtoWithPayment(Loan loan);
}
