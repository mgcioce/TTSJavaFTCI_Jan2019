package com.techtalentsouth.javascriptblog.controller;

import com.techtalentsouth.javascriptblog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
