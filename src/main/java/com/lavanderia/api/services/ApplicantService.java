package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ProviderService providerService;
    private final ProductService productService;

    public ApplicantService(ApplicantRepository applicantRepository, ProviderService providerService, ProductService productService) {
        this.applicantRepository = applicantRepository;
        this.providerService = providerService;
        this.productService = productService;
    }

    @Transactional
    public Applicant createApplicant(CreateRecord createRecord) {

        // Record to Entity
        var applicant = new Applicant(
                createRecord.applicantName(),
                createRecord.applicantCpf(),
                createRecord.applicantEmail(),
                createRecord.applicantPhone(),
                createRecord.applicantResponsible()
        );

        this.applicantRepository.save(applicant);
        var provider = this.providerService.createprovider(createRecord, applicant);
        this.productService.createProduct(createRecord, applicant, provider);

        return applicant;
    }

    public Applicant findApplicantById(Long id) throws Exception {
        return applicantRepository.findById(id).orElseThrow(() -> new Exception("Id not found"));
    }
}
