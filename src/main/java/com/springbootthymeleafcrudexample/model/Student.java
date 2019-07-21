package com.springbootthymeleafcrudexample.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by A.A.MAMUN on 7/19/2019.
 */
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "StudentSequence", sequenceName = "StudentSequence", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="StudentSequence")
    private Integer id;
    private String name;
    private String fatherName;
    private String address;
    private String dob;

    public Student(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}

