package com.lavanderia.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicant")
public class Applicant extends People{


    private String cpf;
    private String responsible;

    @OneToOne
    private Provider provider;

    public Applicant(){}

    public Applicant(String name, String cpf, String email, String phone, String responsible) {
        super(name, email,  phone);
        this.cpf = cpf;
        this.responsible = responsible;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
