package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class StudentDetails {
    private @Id @GeneratedValue Long id;
    private String name;
    StudentDetails(String name){
        this.name=name;
    }


    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof StudentDetails))
            return false;
        StudentDetails employee = (StudentDetails) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "StudentDetails{" + "id=" + this.id + ", name=" + this.name +'}';
    }
}
