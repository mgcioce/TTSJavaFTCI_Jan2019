package com.techtalentsouth.javascriptblog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;
    private String blogEntry;

    public BlogEntry() {
        super();
    }

    public BlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Long getEntryId() {
        return this.entryId;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    public String getBlogEntry() {
        return this.blogEntry;
    }

    @Override
    public String toString() {
        return this.blogEntry;
    }
}
