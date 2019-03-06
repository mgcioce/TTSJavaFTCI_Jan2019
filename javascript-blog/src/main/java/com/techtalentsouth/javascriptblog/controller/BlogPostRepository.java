package com.techtalentsouth.javascriptblog.controller;

import com.techtalentsouth.javascriptblog.model.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost,Long> {
}
