package com.tts.blog.controller;

import com.tts.blog.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogPostController {

    //private BlogPost blogPost;
    //@Autowired
    private ArrayList<BlogPost> blogPosts;

    /*
    This @Autowired annotation searches for first a similar name, then a similar type, to
    assign an object to this field via Dependency Injection. In this case, it notices the
    BlogPostRepository interface and creates a new object whose class has implemented the
    BlogPostRepository interface with the default implementations specified to use BlogPost
    and Long objects.
     */

//    @Autowired
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


//    public void setBlogPost(BlogPost blogPost) {
//        this.blogPost = blogPost;
//    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts",this.blogPosts);
        return "blogpost/index";
    }

    @GetMapping("/blog-post/{id}/edit")
    public String editBlogEntryView(@PathVariable("id") Long id, Model model) {
        Optional<BlogPost> op = bpr.findById(id);
        //System.out.println(op.get().toString());
        model.addAttribute("blogPost",op.get());
        return "blogPost/edit";
    }

    @PutMapping("/blog-post/{id}/edit")
    public String editBlogEntryPut(BlogPost bp, Model model) {
        bpr.save(bp);
        mirrorDB();
        model.addAttribute("title",bp.getTitle());
        model.addAttribute("author",bp.getAuthor());
        model.addAttribute("blogEntry",bp.getPost());
        return "blogpost/result";
    }

    @GetMapping("/blog-post/new")
    public String newEntry(BlogPost bp) {

        return "blogpost/new";
    }

    @PostMapping("/blog-post/new")
    public String addNewBlogPost(BlogPost bp, Model model) {
        bpr.save(bp);
        blogPosts.add(bp);
        model.addAttribute("title",bp.getTitle());
        model.addAttribute("author",bp.getAuthor());
        model.addAttribute("blogEntry",bp.getPost());
        return "blogpost/result";
    }

    @DeleteMapping("/blog-post/{id}/delete")
    public String deleteBlogPost(@PathVariable("id") Long id) {
        bpr.deleteById(id);
        mirrorDB();
        return "blogpost/result";
    }


}
