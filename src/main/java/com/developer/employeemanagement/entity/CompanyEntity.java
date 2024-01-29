package com.developer.employeemanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mt_company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_establish")
    private Date dateOfEstablish;


    public CompanyEntity() {
    }

    public CompanyEntity(Long id, String name, String address, Date dateOfEstablish) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfEstablish = dateOfEstablish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfEstablish() {
        return dateOfEstablish;
    }

    public void setDateOfEstablish(Date dateOfEstablish) {
        this.dateOfEstablish = dateOfEstablish;
    }
}
