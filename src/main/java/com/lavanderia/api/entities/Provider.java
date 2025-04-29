package com.lavanderia.api.entities;

import com.lavanderia.api.entities.people.People;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "providers")
public class Provider extends People {

    private String cnpj;

    @OneToOne
    private Applicant applicant;

    @OneToMany(mappedBy = "provider")
    private List<Product> product;

    public Provider() {
    }

    public Provider(String name, String email, String phone, String cnpj) {
        super(name, email, phone);
        this.cnpj = cnpj;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }



}
