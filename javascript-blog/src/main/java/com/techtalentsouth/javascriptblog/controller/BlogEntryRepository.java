package com.techtalentsouth.javascriptblog.controller;

import com.techtalentsouth.javascriptblog.model.BlogEntry;
import org.springframework.data.repository.CrudRepository;

public interface BlogEntryRepository extends CrudRepository<BlogEntry,Long> {
}
