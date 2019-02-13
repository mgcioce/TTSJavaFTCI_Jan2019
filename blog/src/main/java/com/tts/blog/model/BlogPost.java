package com.tts.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String post;

    public BlogPost() {super();}

    public BlogPost(String author, String title, String post) {
        this.author = author;
        this.title = title;
        this.post = post;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return this.post;
    }

    @Override
    public String toString() {
        return "BlogPost [id=" + this.id + ", author=" + author + ", title=" + title + ", post=" + post + "]";
    }

}
