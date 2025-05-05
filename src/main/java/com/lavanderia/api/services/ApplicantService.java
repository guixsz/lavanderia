package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.dto.ApplicantPut;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ProviderService providerService;
    private final ProductService productService;
    private final AddressService addressService;

    public ApplicantService(ApplicantRepository applicantRepository, ProviderService providerService, ProductService productService, AddressService addressService) {
        this.applicantRepository = applicantRepository;
        this.providerService = providerService;
        this.productService = productService;
        this.addressService = addressService;
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
        var address = this.addressService.createAddress(createRecord, applicant, provider);
        var product = this.productService.createProduct(createRecord, applicant, provider, address);

        return applicant;
    }

    @Transactional
    public Applicant putApplicant(ApplicantPut putData, Long id) throws Exception {
        Applicant applicant = findApplicantById(id);

        if(!putData.responsible().isEmpty()) applicant.setResponsible(putData.responsible());
        if(!putData.phone().isEmpty()) applicant.setTelephone(putData.phone());
        if(!putData.email().isEmpty()) applicant.setEmail(putData.email());
        if(!putData.cpf().isEmpty()) applicant.setCpf(putData.cpf());
        if(!putData.name().isEmpty()) applicant.setName(putData.name());

        return applicantRepository.save(applicant);
    }

    public Applicant findApplicantById(Long id) throws Exception {
        return applicantRepository.findById(id).orElseThrow(() -> new Exception("Id not found"));
    }
}
