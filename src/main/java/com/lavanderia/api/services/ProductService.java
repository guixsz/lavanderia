package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.dto.DetailsRequest;
import com.lavanderia.api.entities.Address;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.entities.Product;
import com.lavanderia.api.entities.Provider;
import com.lavanderia.api.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(CreateRecord createRecord, Applicant applicant, Provider provider, Address address) {
        LocalDateTime dateNow = LocalDateTime.now();

        var product = new Product(
                createRecord.productType(),
                createRecord.productQuantity(),
                createRecord.productValue(),
                subTotal(createRecord.productValue(), createRecord.productQuantity()),
                dateNow,
                pickupDate(dateNow)
        );

        product.setApplicants(applicant);
        product.setProvider(provider);
        product.setAddress(address);

        return productRepository.save(product);
    }

    public LocalDateTime pickupDate(LocalDateTime dateTime) {
        return dateTime.plusDays(2);
    }

    public BigDecimal subTotal (BigDecimal value, Integer quant) {
        return value.multiply(BigDecimal.valueOf(quant));
    }

    public List<DetailsRequest> findDetailsProduct(int page,
                                                   int items) {
        List<Product> details= productRepository.findProductApplicantAndProvider(PageRequest.of(page, items));

        return converting(details);
    }

    public List<DetailsRequest> findDetailsProductByCpf(String cpf, int page, int items) {

        List<Product> details = productRepository.findProductByCpfApplicant(cpf, PageRequest.of(page, items));

        return converting(details);
    }

    public List<DetailsRequest> converting(List<Product> products) {
        return products.stream().map(
                detail -> new DetailsRequest(
                        detail.getApplicants().getName(),
                        detail.getApplicants().getId(),
                        detail.getApplicants().getCpf(),
                        detail.getApplicants().getPhone(),
                        detail.getApplicants().getResponsible(),
                        detail.getProvider().getName(),
                        detail.getProvider().getPhone(),
                        detail.getType(),
                        detail.getSubTotal(),
                        detail.getAddress().getApartmentNumber(),
                        detail.getAddress().getFloor(),
                        detail.getOrderData(),
                        detail.getPickupDate()
                ))
                .toList();
    }
}
