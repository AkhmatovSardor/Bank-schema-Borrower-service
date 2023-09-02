package com.company.Bankborrowerservice.repository;

import com.company.Bankborrowerservice.entity.Borrower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower,Integer> {
    Optional<Borrower>findByBorrowIdAndDeletedAtIsNull(Integer id);
    Optional<Borrower>findByCustomerIdAndDeletedAtIsNull(Integer id);
}
