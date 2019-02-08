package com.techtalentsouth.demo.h2Explore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    private Customer() {
        super();
    }

    public Customer(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public void setFirstName(String first) {
        this.firstName = first;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String last) {
        this.lastName = last;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "Customer [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + "]";
    }
}
