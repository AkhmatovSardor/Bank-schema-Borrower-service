package com.company.Bankborrowerservice.service.validate;

import com.company.Bankborrowerservice.dto.BorrowerDto;
import com.company.Bankborrowerservice.dto.ErrorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BorrowerValidate {
    public List<ErrorDto> validate(BorrowerDto dto) {
        List<ErrorDto> errors=new ArrayList<>();
        return errors;
    }
}
