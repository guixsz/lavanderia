package com.lavanderia.api.services;

import com.lavanderia.api.dto.ApplicantRecord;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    private ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant createApplicant(ApplicantRecord applicantRecord) {

        // Record to Entity
        var applicant = new Applicant(
                applicantRecord.name(),
                applicantRecord.cpf(),
                applicantRecord.email(),
                applicantRecord.phone(),
                applicantRecord.responsible()
        );

        return applicantRepository.save(applicant);
    }

    public Applicant findApplicantById(Long id) throws Exception {
        return applicantRepository.findById(id).orElseThrow(() -> new Exception("Id not found"));
    }
}
