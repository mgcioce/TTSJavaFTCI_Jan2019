package com.techtalentsouth.demo.h2Explore.repository;
import com.techtalentsouth.demo.h2Explore.domain.*;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    List<Customer> findByLastName(String last);
}
