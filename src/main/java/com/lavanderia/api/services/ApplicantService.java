package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    private ApplicantRepository applicantRepository;
    private ProviderService providerService;

    public ApplicantService(ApplicantRepository applicantRepository, ProviderService providerService) {
        this.applicantRepository = applicantRepository;
        this.providerService = providerService;
    }

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
        this.providerService.createprovider(createRecord, applicant);

        return applicant;
    }

    public Applicant findApplicantById(Long id) throws Exception {
        return applicantRepository.findById(id).orElseThrow(() -> new Exception("Id not found"));
    }
}
