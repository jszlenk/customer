package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firsName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public Customer(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
