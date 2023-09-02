package com.company.Bankborrowerservice.service.validate;

import com.company.Bankborrowerservice.dto.ErrorDto;
import com.company.Bankborrowerservice.dto.LoanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoanValidate {
   // private final AccountService accountService;
    public List<ErrorDto> validate(LoanDto dto) {
        List<ErrorDto>errors=new ArrayList<>();
      //  if (accountService.get(dto.getAccountId()).getData()==null){
        //    errors.add(new ErrorDto("account",String.format("This %d id account not found!",dto.getAccountId())));
        //}
        return errors;
    }
}
