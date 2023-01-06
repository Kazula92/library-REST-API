package com.kodilla.repository;

import com.kodilla.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends CrudRepository<Reader,Long> {
}
