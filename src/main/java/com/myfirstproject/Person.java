package com.myfirstproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

    @Id
    /*@Column(name="Id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private int id;
    private String name;    
    private String country;

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", country=" + country + '}';
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person(int id,String name, String country) {
        this.name = name;
        this.id = id;
        this.country = country;
    }

}
