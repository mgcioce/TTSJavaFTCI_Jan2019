package com.tts.blog.controller;

import com.tts.blog.model.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogPostController {


    private ArrayList<BlogPost> blogPosts;

    private BlogPostRepository bpr;

    public BlogPostController(ArrayList<BlogPost> blogPosts, BlogPostRepository bpr) {
        this.bpr = bpr;
        this.blogPosts = blogPosts;
    }

    private void mirrorDB() {
        Iterable<BlogPost> blogList = bpr.findAll();
        blogPosts.clear();
        for(BlogPost blog: blogList) {
            blogPosts.add(blog);
        }
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts",this.blogPosts);
        return "index";
    }

    @GetMapping("/blog-post/{id}/edit")
    public String editBlogEntryView(@PathVariable("id") Long id, Model model) {
        Optional<BlogPost> op = bpr.findById(id);
        model.addAttribute("blogPost",op.get());
        return "edit";
    }

    @PutMapping("/blog-post/{id}/edit")
    public String editBlogEntryPut(BlogPost bp, Model model) {
        bpr.save(bp);
        mirrorDB();
        model.addAttribute("title",bp.getTitle());
        model.addAttribute("author",bp.getAuthor());
        model.addAttribute("blogEntry",bp.getPost());
        return "result";
    }

    @GetMapping("/blog-post/new")
    public String newEntry(BlogPost bp) {

        return "new";
    }

    @PostMapping("/blog-post/new")
    public String addNewBlogPost(BlogPost bp, Model model) {
        bpr.save(bp);
        blogPosts.add(bp);
        model.addAttribute("title",bp.getTitle());
        model.addAttribute("author",bp.getAuthor());
        model.addAttribute("blogEntry",bp.getPost());
        return "result";
    }

    @DeleteMapping("/blog-post/{id}/delete")
    public String deleteBlogPost(@PathVariable("id") Long id) {
        bpr.deleteById(id);
        mirrorDB();
        return "result";
    }


}
