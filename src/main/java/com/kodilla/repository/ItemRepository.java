package com.kodilla.repository;

import com.kodilla.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository <Item, Long> {
}
