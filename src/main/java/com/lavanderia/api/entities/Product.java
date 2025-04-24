package com.lavanderia.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer quantity;
    private BigDecimal value;

    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "order_data")
    private LocalDateTime orderData;


    @ManyToOne
    private Applicant applicants;

    @ManyToOne
    private Provider provider;

    public Product() {
    }

    public Product(String type, Integer quantity, BigDecimal value, BigDecimal subTotal, LocalDateTime orderData) {
        this.type = type;
        this.quantity = quantity;
        this.value = value;
        this.subTotal = subTotal;
        this.orderData = orderData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public LocalDateTime getOrderData() {
        return orderData;
    }

    public void setOrderData(LocalDateTime orderData) {
        this.orderData = orderData;
    }

    public Applicant getApplicants() {
        return applicants;
    }

    public void setApplicants(Applicant applicants) {
        this.applicants = applicants;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
