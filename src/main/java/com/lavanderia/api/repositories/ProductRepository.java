package com.lavanderia.api.repositories;

import com.lavanderia.api.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.applicants a JOIN p.provider pr JOIN p.address ad")
    List<Product> findProductApplicantAndProvider(Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.applicants a JOIN p.provider pr JOIN p.address ad WHERE a.cpf = :cpf")
    List<Product> findProductByCpfApplicant(String cpf, Pageable pageable);
}
