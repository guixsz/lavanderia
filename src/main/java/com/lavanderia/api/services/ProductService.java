package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.dto.DetailsRequest;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.entities.Product;
import com.lavanderia.api.entities.Provider;
import com.lavanderia.api.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(CreateRecord createRecord, Applicant applicant, Provider provider) {
        var product = new Product(
                createRecord.productType(),
                createRecord.productQuantity(),
                createRecord.productValue(),
                createRecord.productSubTotal()
        );

        product.setApplicants(applicant);
        product.setProvider(provider);

        return productRepository.save(product);
    }

    public List<DetailsRequest> findDetailsProduct(int page,
                                                   int items) {
        List<Product> details= productRepository.findProductApplicantAndProvider(PageRequest.of(page, items));

        return details.stream().map(
                detail -> new DetailsRequest(
                        detail.getApplicants().getName(),
                        detail.getApplicants().getId(),
                        detail.getApplicants().getCpf(),
                        detail.getApplicants().getPhone(),
                        detail.getApplicants().getResponsible(),
                        detail.getProvider().getName(),
                        detail.getProvider().getPhone(),
                        detail.getType(),
                        detail.getSubTotal()
                ))
                .toList();
    }
}
