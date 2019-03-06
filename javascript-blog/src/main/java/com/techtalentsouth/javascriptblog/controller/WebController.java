package com.techtalentsouth.javascriptblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private BlogEntryRepository ber;
    private BlogPostRepository bpr;
    private AuthorRepository ar;

    public WebController() {
        super();
    }

    public WebController(BlogPostRepository bpr, BlogEntryRepository ber, AuthorRepository ar) {
        this.bpr = bpr;
        this.ber = ber;
        this.ar = ar;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
