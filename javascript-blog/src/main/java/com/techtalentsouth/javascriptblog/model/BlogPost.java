package com.techtalentsouth.javascriptblog.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Author author;
    @OneToOne
    private BlogEntry entry;
    private Instant dateCreated;
    private Instant dateModified;

    public BlogPost() {
        super();
    }

    public BlogPost(Author author, BlogEntry entry, Instant date) {
        this.author = author;
        this.entry = entry;
        this.dateCreated = date;
        this.dateModified = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setEntry(BlogEntry entry) {
        this.entry = entry;
    }

    public BlogEntry getEntry() {
        return entry;
    }

    public void setDateCreated(Instant date) {
        this.dateCreated = date;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateModified(Instant dateModified) {
        this.dateModified = dateModified;
    }

    public Instant getDateModified() {
        return dateModified;
    }

    @Override
    public String toString() {
        return "\n\tid: " + id.toString() + "\n\tauthor: " + author.toString() +
                "\n\tdate posted: " + dateCreated.toString() + "\n\tdate edited: " +
                dateModified.toString() + "\n\tEntry: "+ entry.toString();
    }
}
