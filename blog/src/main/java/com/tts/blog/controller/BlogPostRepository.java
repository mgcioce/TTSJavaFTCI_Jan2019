package com.tts.blog.controller;

import com.tts.blog.model.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost,Long> {

}
