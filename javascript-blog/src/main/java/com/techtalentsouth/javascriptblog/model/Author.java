package com.techtalentsouth.javascriptblog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private String firstName;
    private String lastName;
    private String blogAlterEgo;
    private boolean alterEgo;
    private String email;
    private String password;
    private Instant dateRegistered;

    public Author() {
        super();
    }

    public Author(String firstName, String lastName, String blogAlterEgo, boolean alterEgo,
                    String email, String password, Instant dateRegistered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogAlterEgo = blogAlterEgo;
        this.alterEgo = alterEgo;
        this.email = email;
        this.password = password;
        this.dateRegistered = dateRegistered;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setBlogAlterEgo(String blogAlterEgo) {
        this.blogAlterEgo = blogAlterEgo;
    }

    public String getBlogAlterEgo() {
        return this.blogAlterEgo;
    }

    public void setAlterEgo(boolean alterEgo) {
        this.alterEgo = alterEgo;
    }

    public boolean hasAlterEgo() {
        return alterEgo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDateRegistered(Instant dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Instant getDateRegistered() {
        return this.dateRegistered;
    }

    @Override
    public String toString() {
        if (hasAlterEgo()) {
            return this.blogAlterEgo;
        } else {
            return this.firstName + " " + this.lastName;
        }
    }
}
