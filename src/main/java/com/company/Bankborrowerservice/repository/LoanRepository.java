package com.company.Bankborrowerservice.repository;

import com.company.Bankborrowerservice.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Integer> {
    Optional<Loan> findByLoanIdAndDeletedAtIsNull(Integer id);
    Set<Loan> findAllByBranchIdAndDeletedAtIsNull(Integer id);
}
