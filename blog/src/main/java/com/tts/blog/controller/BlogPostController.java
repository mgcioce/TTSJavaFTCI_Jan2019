package com.tts.blog.controller;

import com.tts.blog.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BlogPostController {

    private BlogPost bp;

    @Autowired
    private BlogPostRepository bpr;

    @GetMapping("/")
    public String index(BlogPost bp) {

        return "blogpost/index";
    }

    @PostMapping("/")
    public String addNewBlogPost(BlogPost bp, Model model) {
        //BlogPost nextPost = new BlogPost(bp.getAuthor(), bp.getTitle(), bp.getPost());
        bpr.save(bp);
        model.addAttribute("title",bp.getTitle());
        model.addAttribute("author",bp.getAuthor());
        model.addAttribute("blogEntry",bp.getPost());
        return "blogpost/result";
    }


}
