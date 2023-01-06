package com.kodilla.repository;

import com.kodilla.domain.BorrowingBooks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingBooksRepository extends CrudRepository<BorrowingBooks, Long> {
}
