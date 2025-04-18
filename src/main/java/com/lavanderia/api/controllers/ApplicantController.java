package com.lavanderia.api.controllers;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.services.ApplicantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<Applicant> createApplicant(@Valid @RequestBody CreateRecord applicantRecord) {
        Applicant applicant = applicantService.createApplicant(applicantRecord);
        return  ResponseEntity.created(URI.create("/applicants/" + applicant.getId().toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> findApplicantById(@PathVariable Long id) throws Exception {
        Applicant applicantFound = applicantService.findApplicantById(id);
        return ResponseEntity.ok(applicantFound);
    }
}
