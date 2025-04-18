package com.lavanderia.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "providers")
public class Provider extends People{

    private String cnpj;

    @OneToOne
    private Applicant applicant;

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
